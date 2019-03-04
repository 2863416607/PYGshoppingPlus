package com.shop.pyg.service;

import com.shop.pyg.domain.Seller;
import com.shop.pyg.mapper.SellerMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: 陈远明
 * @Date: 2019/3/1 18 : 58
 * @Description:
 */
public interface SellerService {

    Seller selectOne(String username);
}
