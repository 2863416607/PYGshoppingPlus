package com.shop.pyg.service;

import com.shop.pyg.domain.ItemCat;

import java.util.List;

/**
 * @作者: 段清刚
 * @日期时间: 2019/2/2714:09
 * @功能描述:
 * @see
 */
public interface ItemCatService {

    /*
     *功能描述 顶级商品分类
     * @author qqg
     * @date 2019/2/27
     * @param No such property: code for class: Script1
     * @return
     */
    List<ItemCat> selectTop();

    List<ItemCat> selectByParentId(Long id);
}
