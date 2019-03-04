package com.shop.pyg.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.pyg.domain.GoodsDesc;
import com.shop.pyg.entity.PageResult;
import com.shop.pyg.mapper.GoodsDescMapper;
import com.shop.pyg.service.GoodsDescService;
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
public class GoodsDescServiceImpl implements GoodsDescService {

	@Autowired
	private GoodsDescMapper goodsDescMapper;

	/**
	 * 查询全部
	 */
	@Override
	public List<GoodsDesc> findAll() {
		return goodsDescMapper.selectList(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<GoodsDesc> page = (Page<GoodsDesc>) goodsDescMapper.selectList(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(GoodsDesc goodsDesc) {
		goodsDescMapper.insert(goodsDesc);
	}


	/**
	 * 修改
	 */
	@Override
	public void update(GoodsDesc goodsDesc) {
		goodsDescMapper.updateById(goodsDesc);
	}

	/**
	 * 根据ID获取实体
	 *
	 * @param id
	 * @return
	 */
	@Override
	public GoodsDesc findOne(Long id) {
		return goodsDescMapper.selectById(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			goodsDescMapper.deleteById(id);
		}
	}


	@Override
	public PageResult findPage(GoodsDesc goodsDesc, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		QueryWrapper wrapper = new QueryWrapper();


			if (goodsDesc != null) {
				if (goodsDesc.getIntroduction() != null && goodsDesc.getIntroduction().length() > 0) {
					wrapper.like("introduction", goodsDesc.getIntroduction());
				}
				if (goodsDesc.getSpecificationItems() != null && goodsDesc.getSpecificationItems().length() > 0) {
					wrapper.like("specification_items", goodsDesc.getSpecificationItems());
				}
				if (goodsDesc.getCustomAttributeItems() != null && goodsDesc.getCustomAttributeItems().length() > 0) {
					wrapper.like("custom_attribute_items", goodsDesc.getCustomAttributeItems());
				}
				if (goodsDesc.getItemImages() != null && goodsDesc.getItemImages().length() > 0) {
					wrapper.like("item_images", goodsDesc.getItemImages());
				}
				if (goodsDesc.getPackageList() != null && goodsDesc.getPackageList().length() > 0) {
					wrapper.like("package_list", goodsDesc.getPackageList());
				}
				if (goodsDesc.getSaleService() != null && goodsDesc.getSaleService().length() > 0) {
					wrapper.like("sale_service", goodsDesc.getSaleService());
				}
			}
		Page<GoodsDesc> page = (Page<GoodsDesc>) goodsDescMapper.selectList(wrapper);
		return new PageResult(page.getTotal(), page.getResult());
		}
	}
