package com.shop.pyg.vo;

import com.shop.pyg.domain.ItemCat;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @作者: 段清刚
 * @日期时间: 2019/2/2817:09
 * @功能描述:index页面Itemcat
 * @see
 */
public class ItemCatVo implements Serializable {

    private static final long serialVersionUID = 5036830156807165493L;
    private ItemCat parentItemCat;
    private List<ItemCatVo2> itemCats;

    public ItemCat getParentItemCat() {
        return parentItemCat;
    }

    public void setParentItemCat(ItemCat parentItemCat) {
        this.parentItemCat = parentItemCat;
    }

    public List<ItemCatVo2> getItemCats() {
        return itemCats;
    }

    public void setItemCats(List<ItemCatVo2> itemCats) {
        this.itemCats = itemCats;
    }
}
