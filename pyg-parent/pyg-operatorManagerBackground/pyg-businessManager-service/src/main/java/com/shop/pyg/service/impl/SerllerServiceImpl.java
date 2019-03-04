package com.shop.pyg.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.pyg.domain.Seller;
import com.shop.pyg.exception.CustomException;
import com.shop.pyg.mapper.SellerMapper;
import com.shop.pyg.service.SellerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: 黄军
 * @Date: 2019/2/22 11 : 27
 * @Description:
 */
@Service(timeout =6000)
@Transactional
public class SerllerServiceImpl implements SellerService {


    @Autowired
    private SellerMapper sellerMapper;

    @Override
    public PageInfo<Seller> querypage(Seller seller, int pageNum, int pageSize) throws IllegalAccessException {


        PageHelper.startPage(pageNum,pageSize);

        QueryWrapper<Seller> queryWrapper=new QueryWrapper();

        queryWrapper.eq("status","0");

        if (StringUtils.isNotBlank(seller.getName())){
            queryWrapper.like("name",seller.getName());
        }

        if (StringUtils.isNotBlank(seller.getNickName())){
            queryWrapper.like("nick_name",seller.getNickName());
        }
        if (StringUtils.isNotBlank(seller.getSellerId())){
            queryWrapper.like("seller_id",seller.getSellerId());
        }
        List<Seller> sellers = this.sellerMapper.selectList(queryWrapper);

        return new PageInfo<>(sellers);
    }

    @Override
    public void changestatus(Seller seller) {

       this.sellerMapper.updateById(seller);
    }

    @Override
    public Seller querybyid(String id) {
        if (StringUtils.isBlank(id)){

            throw new CustomException("id不能为空");
        }

        Seller seller = this.sellerMapper.selectById(id);

        return seller;
    }

    @Override
    public PageInfo<Seller> querypage1(Seller seller, int page, int rows,String status) {
        PageHelper.startPage(page,rows);

        QueryWrapper<Seller> queryWrapper=new QueryWrapper();

        queryWrapper.notIn("status","0");

        if (StringUtils.isNotBlank(seller.getName())){
            queryWrapper.like("name",seller.getName());
        }

        if (StringUtils.isNotBlank(seller.getNickName())){
            queryWrapper.like("nick_name",seller.getNickName());
        }
        if (StringUtils.isNotBlank(seller.getSellerId())){
            queryWrapper.like("seller_id",seller.getSellerId());
        }

        if (StringUtils.isNotBlank(status)){
            queryWrapper.eq("status",status);
        }

        List<Seller> sellers = this.sellerMapper.selectList(queryWrapper);

        return new PageInfo<>(sellers);
    }

}
