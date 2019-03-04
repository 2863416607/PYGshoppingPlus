package com.shop.pyg.service.impl;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shop.pyg.domain.Goods;
import com.shop.pyg.domain.GoodsDesc;
import com.shop.pyg.entity.PageResult;
import com.shop.pyg.mapper.*;
import com.shop.pyg.service.GoodsService;
import com.shop.pyg.vo.GoodsVO;
import org.apache.solr.common.util.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Goods> findAll() {
		return goodsMapper.selectList(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Goods> page=   (Page<Goods>) goodsMapper.selectList(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Autowired
	private GoodsDescMapper goodsDescMapper;
	
	@Autowired
	private ItemMapper itemMapper;
	
	@Autowired
	private ItemCatMapper itemCatMapper;
	
	@Autowired
	private BrandMapper brandMapper;
	
	@Autowired
	private SellerMapper sellerMapper;
	/**
	 * 增加
	 */
	@Override
	public void add(GoodsVO goodsVO) {
		goodsVO.getGoods().setAuditStatus("0"); // 设置审核的状态
		
		goodsMapper.insert(goodsVO.getGoods()); // 插入商品信息

		goodsVO.getGoodsDesc().setGoodsId(goodsVO.getGoods().getId());
		
		goodsDescMapper.insert(goodsVO.getGoodsDesc()); // 插入商品的扩展信息
		
		//setItemList(goods);
	}
	
	/*private void setItemList(Goods goods){
		if("1".equals(goods.getGoods().getIsEnableSpec())){
			// 启用规格
			// 保存SKU列表的信息:
			for(TbItem item:goods.getItemList()){
				// 设置SKU的数据：
				// item.setTitle(title);
				String title = goods.getGoods().getGoodsName();
				Map<String,String> map = JSON.parseObject(item.getSpec(), Map.class);
				//Map<String,String> map = item.getSpec();
				for (String key : map.keySet()) {
					title+= " "+map.get(key);
				}
				item.setTitle(title);

				setValue(goods,item);

				itemMapper.insert(item);
			}
		}else{
			// 没有启用规格
			TbItem item = new TbItem();

			item.setTitle(goods.getGoods().getGoodsName());

			item.setPrice(goods.getGoods().getPrice());

			item.setNum(999);

			item.setStatus("0");

			item.setIsDefault("1");
			item.setSpec("{}");
			//item.setSpec(new HashMap());
			setValue(goods,item);
			itemMapper.insert(item);
		}
	}

	private void setValue(Goods goods,TbItem item){
		List<Map> imageList = JSON.parseArray(goods.getGoodsDesc().getItemImages(),Map.class);
		if(imageList.size()>0){
			item.setImage((String)imageList.get(0).get("url"));
		}

		// 保存三级分类的ID:
		item.setCategoryid(goods.getGoods().getCategory3Id());
		item.setCreateTime(new Date());
		item.setUpdateTime(new Date());
		// 设置商品ID
		item.setGoodsId(goods.getGoods().getId());
		item.setSellerId(goods.getGoods().getSellerId());

		TbItemCat itemCat = itemCatMapper.selectByPrimaryKey(goods.getGoods().getCategory3Id());
		item.setCategory(itemCat.getName());

		TbBrand brand = brandMapper.selectByPrimaryKey(goods.getGoods().getBrandId());
		item.setBrand(brand.getName());

		TbSeller seller = sellerMapper.selectByPrimaryKey(goods.getGoods().getSellerId());
		item.setSeller(seller.getNickName());
	}

	*//**
	 * 修改
	 *//*

	@Override
	public void update(Goods goods){
		// 修改商品信息
		goods.getGoods().setAuditStatus("0");
		goodsMapper.updateByPrimaryKey(goods.getGoods());
		// 修改商品扩展信息:
		goodsDescMapper.updateByPrimaryKey(goods.getGoodsDesc());
		// 修改SKU信息:
		// 先删除，再保存:
		// 删除SKU的信息:
		TbItemExample example = new TbItemExample();
		com.pinyougou.pojo.TbItemExample.Criteria criteria = example.createCriteria();
		criteria.andGoodsIdEqualTo(goods.getGoods().getId());
		itemMapper.deleteByExample(example);
		// 保存SKU的信息
		setItemList(goods);
	}

	*//**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 *//*
	@Override
	public Goods findOne(Long id){
		Goods goods = new Goods();
		// 查询商品表的信息
		Goods Goods = goodsMapper.selectByPrimaryKey(id);
		goods.setGoods(Goods);
		// 查询商品扩展表的信息
		GoodsDesc GoodsDesc = goodsDescMapper.selectByPrimaryKey(id);
		goods.setGoodsDesc(GoodsDesc);

		// 查询SKU表的信息:
		TbItemExample example = new TbItemExample();
		com.pinyougou.pojo.TbItemExample.Criteria criteria = example.createCriteria();
		criteria.andGoodsIdEqualTo(id);
		List<TbItem> list = itemMapper.selectByExample(example);
		goods.setItemList(list);

		return goods;
	}

	*//**
	 * 批量删除
	 *//*
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
//			goodsMapper.deleteByPrimaryKey(id);
			Goods Goods = goodsMapper.selectByPrimaryKey(id);
			Goods.setIsDelete("1");
			goodsMapper.updateByPrimaryKey(Goods);
		}
	}


	@Override
	public PageResult findPage(Goods goods, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		GoodsExample example=new GoodsExample();
		Criteria criteria = example.createCriteria();

		criteria.andIsDeleteIsNull();

		if(goods!=null){
			if(goods.getSellerId()!=null && goods.getSellerId().length()>0){
				criteria.andSellerIdEqualTo(goods.getSellerId());
			}
			if(goods.getGoodsName()!=null && goods.getGoodsName().length()>0){
				criteria.andGoodsNameLike("%"+goods.getGoodsName()+"%");
			}
			if(goods.getAuditStatus()!=null && goods.getAuditStatus().length()>0){
				criteria.andAuditStatusLike("%"+goods.getAuditStatus()+"%");
			}
			if(goods.getIsMarketable()!=null && goods.getIsMarketable().length()>0){
				criteria.andIsMarketableLike("%"+goods.getIsMarketable()+"%");
			}
			if(goods.getCaption()!=null && goods.getCaption().length()>0){
				criteria.andCaptionLike("%"+goods.getCaption()+"%");
			}
			if(goods.getSmallPic()!=null && goods.getSmallPic().length()>0){
				criteria.andSmallPicLike("%"+goods.getSmallPic()+"%");
			}
			if(goods.getIsEnableSpec()!=null && goods.getIsEnableSpec().length()>0){
				criteria.andIsEnableSpecLike("%"+goods.getIsEnableSpec()+"%");
			}
			if(goods.getIsDelete()!=null && goods.getIsDelete().length()>0){
				criteria.andIsDeleteLike("%"+goods.getIsDelete()+"%");
			}

		}

		Page<Goods> page= (Page<Goods>)goodsMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public void updateStatus(Long[] ids, String status) {
		for (Long id : ids) {
			Goods Goods = goodsMapper.selectByPrimaryKey(id);

			Goods.setAuditStatus(status);

			goodsMapper.updateByPrimaryKey(Goods);
		}
	}
	*/
}
