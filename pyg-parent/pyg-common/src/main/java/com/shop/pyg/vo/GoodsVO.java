package com.shop.pyg.vo;

import com.shop.pyg.domain.Goods;
import com.shop.pyg.domain.GoodsDesc;
import com.shop.pyg.domain.Item;

import java.io.Serializable;
import java.util.List;

/**
 * 商品的组合实体类
 *
 * @author jt
 */

public class GoodsVO implements Serializable {

    private Goods goods; // 商品信息
    private GoodsDesc goodsDesc; // 商品扩展信息

    private List<Item> itemList; // SKU的列表信息

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public GoodsDesc getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(GoodsDesc goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }


}
