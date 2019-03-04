package com.shop.pyg.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.pyg.domain.Item;
import com.shop.pyg.domain.TypeTemplate;
import com.shop.pyg.entity.PageResult;
import com.shop.pyg.mapper.ItemMapper;
import com.shop.pyg.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 服务实现层
 * @author 王德胜
 *
 */
@Service(timeout = 6000)
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper itemMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Item> findAll() {
		return itemMapper.selectList(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Item> page=   (Page<Item>) itemMapper.selectList(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Item item) {
		itemMapper.insert(item);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Item item){
		itemMapper.updateById(item);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Item findOne(Long id){
		return itemMapper.selectById(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			itemMapper.deleteById(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(Item item, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

			QueryWrapper wrapper = new QueryWrapper();

			if (item != null) {
				if(item.getTitle()!=null && item.getTitle().length()>0) {
					wrapper.like("title", item.getTitle());
				}
				if (item.getSellPoint()!=null && item.getSellPoint().length()>0) {
					wrapper.like("sell_point", item.getSellPoint());
				}
				if(item.getBarcode()!=null && item.getBarcode().length()>0) {
					wrapper.like("barcode", item.getBarcode());
				}
				if(item.getImage()!=null && item.getImage().length()>0)  {
					wrapper.like("image", item.getImage());
				}
				if(item.getStatus()!=null && item.getStatus().length()>0)  {
					wrapper.like("status", item.getStatus());
				}
				if(item.getItemSn()!=null && item.getItemSn().length()>0)  {
					wrapper.like("item_sn", item.getItemSn());
				}
				if(item.getIsDefault()!=null && item.getIsDefault().length()>0)  {
					wrapper.like("is_default", item.getIsDefault());
				}
				if(item.getSellerId()!=null && item.getSellerId().length()>0)  {
					wrapper.like("seller_id", item.getSellerId());
				}
				if(item.getCartThumbnail()!=null && item.getCartThumbnail().length()>0)  {
					wrapper.like("cart_thumbnall", item.getCartThumbnail());
				}
				if(item.getCategory()!=null && item.getCategory().length()>0)  {
					wrapper.like("category", item.getCategory());
				}
				if(item.getBrand()!=null && item.getBrand().length()>0)  {
					wrapper.like("brand", item.getBrand());
				}
				if(item.getSeller()!=null && item.getSeller().length()>0){
					wrapper.like("seller", item.getSeller());
				}
			}
			Page<Item> page = (Page<Item>) itemMapper.selectList(wrapper);
			return new PageResult(page.getTotal(), page.getResult());
		}
	}
