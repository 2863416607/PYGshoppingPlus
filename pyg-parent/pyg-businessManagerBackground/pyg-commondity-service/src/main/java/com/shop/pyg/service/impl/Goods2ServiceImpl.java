package com.shop.pyg.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.pyg.domain.Goods;
import com.shop.pyg.mapper.GoodsMapper;
import com.shop.pyg.service.Goods2Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: 陈亮慧
 * @Date: 2019/2/22 16 : 22
 * @Description:
 */
@Service(timeout = 6000)
@Transactional
public class Goods2ServiceImpl implements Goods2Service {

    @Autowired
    private GoodsMapper goodsMapper;

    //查询所有
    @Override
    public List<Goods> findAll() {
        return this.goodsMapper.selectList(null);
    }

    //分页查询
    @Override
    public PageInfo findPage(Integer pageNum, Integer pageSize,Goods goods) {
        PageHelper.startPage(pageNum,pageSize);

        QueryWrapper<Goods> goodsQueryWrapper=new QueryWrapper<>();


        if (StringUtils.isNotBlank(goods.getGoodsName())){
            goodsQueryWrapper.like("goods_name",StringUtils.deleteWhitespace(goods.getGoodsName()));
        }

        if (StringUtils.isNotBlank(goods.getAuditStatus())){
            goodsQueryWrapper.like("audit_status",goods.getAuditStatus());
        }


        List<Goods> brandList = this.goodsMapper.selectList(goodsQueryWrapper);
        PageInfo<Goods> pageInfo = new PageInfo<>(brandList);
        return pageInfo ;
    }

    @Override
    public void delete(Long[] ids) {
        if (ids.length>0){
            this.goodsMapper.deleteBatchIds(Arrays.asList(ids));
        }
    }


    /**
     * 根据ID获取实体
     * @param id
     * @return
     */
    @Override
    public Goods findOne(Goods id){
        return null;
    }

    /**
     * 添加
     * @param goods
     */
    @Override
    public void add(Goods goods){

    }

    @Override
    public String selectByLikeName(Goods goodsName) {
        return null;
    }

    @Override
    public void updateStatus(Long[] ids, String status) {
        for (int i = 0; i < ids.length; i++) {
            Goods goods = this.goodsMapper.selectById(ids[i]);
            goods.setAuditStatus(status);
            this.goodsMapper.updateById(goods);

        }
    }
}
