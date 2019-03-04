package com.shop.pyg.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author team
 * @since 2019-02-19
 */
@TableName("tb_goods")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商家ID
     */
    @TableField("seller_id")
    private String sellerId;

    /**
     * SPU名
     */
    @TableField("goods_name")
    private String goodsName;

    /**
     * 默认SKU
     */
    @TableField("default_item_id")
    private Long defaultItemId;

    /**
     * 状态
     */
    @TableField("audit_status")
    private String auditStatus;

    /**
     * 是否上架
     */
    @TableField("is_marketable")
    private String isMarketable;

    /**
     * 品牌
     */
    @TableField("brand_id")
    private Long brandId;

    /**
     * 副标题
     */
    private String caption;

    /**
     * 一级类目
     */
    @TableField("category1_id")
    private Long category1Id;

    /**
     * 二级类目
     */
    @TableField("category2_id")
    private Long category2Id;

    /**
     * 三级类目
     */
    @TableField("category3_id")
    private Long category3Id;

    /**
     * 小图
     */
    @TableField("small_pic")
    private String smallPic;

    /**
     * 商城价
     */
    private BigDecimal price;

    /**
     * 分类模板ID
     */
    @TableField("type_template_id")
    private Long typeTemplateId;

    /**
     * 是否启用规格
     */
    @TableField("is_enable_spec")
    private String isEnableSpec;

    /**
     * 是否删除
     */
    @TableField("is_delete")
    private String isDelete;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getDefaultItemId() {
        return defaultItemId;
    }

    public void setDefaultItemId(Long defaultItemId) {
        this.defaultItemId = defaultItemId;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getIsMarketable() {
        return isMarketable;
    }

    public void setIsMarketable(String isMarketable) {
        this.isMarketable = isMarketable;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Long getCategory1Id() {
        return category1Id;
    }

    public void setCategory1Id(Long category1Id) {
        this.category1Id = category1Id;
    }

    public Long getCategory2Id() {
        return category2Id;
    }

    public void setCategory2Id(Long category2Id) {
        this.category2Id = category2Id;
    }

    public Long getCategory3Id() {
        return category3Id;
    }

    public void setCategory3Id(Long category3Id) {
        this.category3Id = category3Id;
    }

    public String getSmallPic() {
        return smallPic;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getTypeTemplateId() {
        return typeTemplateId;
    }

    public void setTypeTemplateId(Long typeTemplateId) {
        this.typeTemplateId = typeTemplateId;
    }

    public String getIsEnableSpec() {
        return isEnableSpec;
    }

    public void setIsEnableSpec(String isEnableSpec) {
        this.isEnableSpec = isEnableSpec;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "GoodsVO{" +
        ", id=" + id +
        ", sellerId=" + sellerId +
        ", goodsName=" + goodsName +
        ", defaultItemId=" + defaultItemId +
        ", auditStatus=" + auditStatus +
        ", isMarketable=" + isMarketable +
        ", brandId=" + brandId +
        ", caption=" + caption +
        ", category1Id=" + category1Id +
        ", category2Id=" + category2Id +
        ", category3Id=" + category3Id +
        ", smallPic=" + smallPic +
        ", price=" + price +
        ", typeTemplateId=" + typeTemplateId +
        ", isEnableSpec=" + isEnableSpec +
        ", isDelete=" + isDelete +
        "}";
    }
}
