package com.shop.pyg.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.shop.pyg.domain.Seller;
import com.shop.pyg.mapper.SellerMapper;
import com.shop.pyg.service.UpdateSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: 陈远明
 * @Date: 2019/2/22 14 : 10
 * @Description:
 */
@Service(timeout = 6000)
@Transactional
public class UpdateSellerServiceImpl implements UpdateSellerService {

    @Autowired
    private SellerMapper sellerMapper;

    @Override
    public void update(Seller seller) {
        this.sellerMapper.updateById(seller);
    }
}
