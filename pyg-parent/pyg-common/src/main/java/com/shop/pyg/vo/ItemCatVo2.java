package com.shop.pyg.vo;

import com.shop.pyg.domain.ItemCat;

import java.io.Serializable;
import java.util.List;

/**
 * @作者: 段清刚
 * @日期时间: 2019/2/2822:28
 * @功能描述:
 * @see
 */
public class ItemCatVo2 implements Serializable {

    private static final long serialVersionUID = 1968883427437566276L;
    private ItemCat parenttemCat;
    private List<ItemCat> itemCats;

    public ItemCat getParenttemCat() {
        return parenttemCat;
    }

    public void setParenttemCat(ItemCat parenttemCat) {
        this.parenttemCat = parenttemCat;
    }

    public List<ItemCat> getItemCats() {
        return itemCats;
    }

    public void setItemCats(List<ItemCat> itemCats) {
        this.itemCats = itemCats;
    }
}
