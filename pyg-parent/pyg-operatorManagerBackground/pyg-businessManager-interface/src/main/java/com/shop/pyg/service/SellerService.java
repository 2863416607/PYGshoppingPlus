package com.shop.pyg.service;

import com.github.pagehelper.PageInfo;
import com.shop.pyg.domain.Seller;

/**
 * @Auther: 黄军
 * @Date: 2019/2/22 11 : 27
 * @Description:
 */
public interface SellerService {
    PageInfo<Seller> querypage(Seller seller, int pageNum, int pageSize) throws IllegalAccessException;


    Seller querybyid(String id);


    void changestatus(Seller seller);


    PageInfo<Seller> querypage1(Seller seller, int page, int rows,String status);
}
