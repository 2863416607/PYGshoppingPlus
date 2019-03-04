package com.shop.pyg.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author team
 * @since 2019-02-19
 */
@TableName("tb_goods_desc")
public class GoodsDesc implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * SPU_ID
     */
    @TableId("goods_id")
    private Long goodsId;

    /**
     * 描述
     */
    private String introduction;

    /**
     * 规格结果集，所有规格，包含isSelected
     */
    @TableField("specification_items")
    private String specificationItems;

    /**
     * 自定义属性（参数结果）
     */
    @TableField("custom_attribute_items")
    private String customAttributeItems;

    @TableField("item_images")
    private String itemImages;

    /**
     * 包装列表
     */
    @TableField("package_list")
    private String packageList;

    /**
     * 售后服务
     */
    @TableField("sale_service")
    private String saleService;


    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getSpecificationItems() {
        return specificationItems;
    }

    public void setSpecificationItems(String specificationItems) {
        this.specificationItems = specificationItems;
    }

    public String getCustomAttributeItems() {
        return customAttributeItems;
    }

    public void setCustomAttributeItems(String customAttributeItems) {
        this.customAttributeItems = customAttributeItems;
    }

    public String getItemImages() {
        return itemImages;
    }

    public void setItemImages(String itemImages) {
        this.itemImages = itemImages;
    }

    public String getPackageList() {
        return packageList;
    }

    public void setPackageList(String packageList) {
        this.packageList = packageList;
    }

    public String getSaleService() {
        return saleService;
    }

    public void setSaleService(String saleService) {
        this.saleService = saleService;
    }

    @Override
    public String toString() {
        return "GoodsDesc{" +
        ", goodsId=" + goodsId +
        ", introduction=" + introduction +
        ", specificationItems=" + specificationItems +
        ", customAttributeItems=" + customAttributeItems +
        ", itemImages=" + itemImages +
        ", packageList=" + packageList +
        ", saleService=" + saleService +
        "}";
    }
}
