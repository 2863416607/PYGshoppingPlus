package com.shop.pyg.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shop.pyg.domain.Seller;
import com.shop.pyg.mapper.SellerMapper;
import com.shop.pyg.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: 陈远明
 * @Date: 2019/3/1 18 : 58
 * @Description:
 */
@Service(timeout = 6000)
@Transactional
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerMapper sellerMapper;


    @Override
    public Seller findUserByName(String username) {


        QueryWrapper<Seller> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("seller_id", username);

        return this.sellerMapper.selectOne(queryWrapper);
    }
}
