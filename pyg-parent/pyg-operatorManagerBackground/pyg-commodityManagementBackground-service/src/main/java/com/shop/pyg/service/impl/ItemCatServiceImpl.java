package com.shop.pyg.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.pyg.domain.Item;
import com.shop.pyg.domain.ItemCat;
import com.shop.pyg.entity.PageResult;
import com.shop.pyg.exception.CustomException;
import com.shop.pyg.mapper.ItemCatMapper;
import com.shop.pyg.service.ItemCatService;
import com.shop.pyg.util.rdeis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 服务实现层
 * @author 王德胜
 *
 */
@Service(timeout = 6000)
@Transactional
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private ItemCatMapper itemCatMapper;

	@Autowired
	private RedisUtil redisUtil;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<ItemCat> findAll() {
		return itemCatMapper.selectList(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize ) {
		PageHelper.startPage(pageNum, pageSize);
		Page<ItemCat> page= (Page<ItemCat>) itemCatMapper.selectList(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(ItemCat itemCat) {
		this.redisUtil.del("itemCatVos");
		itemCatMapper.insert(itemCat);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(ItemCat itemCat){
		redisUtil.del("itemCatVos");
		itemCatMapper.updateById(itemCat);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public ItemCat findOne(Long id){
		return itemCatMapper.selectById(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) throws CustomException {
		for(Long id:ids){
			itemCatMapper.deleteById(id);
			QueryWrapper<ItemCat> parent_id = new QueryWrapper<ItemCat>().eq("parent_id", id);
			List<ItemCat> itemCats = itemCatMapper.selectList(parent_id);
			if (!itemCats.isEmpty()){
				this.deletebyparentId(id);
			}
		}
		this.redisUtil.del("itemCatVos");
	}

/**
 * 根据parent_id 删除子类
 * */
	public void deletebyparentId(Long id){
		QueryWrapper<ItemCat> parent_id = new QueryWrapper<ItemCat>().eq("parent_id", id);
		List<ItemCat> itemCats = this.itemCatMapper.selectList(parent_id);
		this.itemCatMapper.delete(parent_id);
		if (!itemCats.isEmpty()){
			for (ItemCat itemCat : itemCats) {
				this.deletebyparentId(itemCat.getId());
			}
		}

		this.redisUtil.del("itemCatVos");
	}
	
	
	@Override
	public PageResult findPage(ItemCat itemCat, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		QueryWrapper wrapper = new QueryWrapper();

		if (itemCat != null) {
			if (itemCat.getName() != null && itemCat.getName().length() > 0) {
				wrapper.like("name", itemCat.getName());
			}
	
		}
		
		Page<ItemCat> page= (Page<ItemCat>)itemCatMapper.selectList(wrapper);
		return new PageResult(page.getTotal(), page.getResult());
	}
		
	@Autowired
	private RedisTemplate redisTemplate;

	@Override
	public List<ItemCat> findByParentId(Long parentId) {
		QueryWrapper wrapper = new QueryWrapper();

		wrapper.eq("parent_id",parentId);

		return itemCatMapper.selectList(wrapper);

	}

}
