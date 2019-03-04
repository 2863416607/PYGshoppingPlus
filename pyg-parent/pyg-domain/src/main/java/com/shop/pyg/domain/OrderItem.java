package com.shop.pyg.domain;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("tb_order_item")
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 商品id
     */
    @TableField("item_id")
    private Long itemId;

    /**
     * SPU_ID
     */
    @TableField("goods_id")
    private Long goodsId;

    /**
     * 订单id
     */
    @TableField("order_id")
    private Long orderId;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品单价
     */
    private BigDecimal price;

    /**
     * 商品购买数量
     */
    private Integer num;

    /**
     * 商品总金额
     */
    @TableField("total_fee")
    private BigDecimal totalFee;

    /**
     * 商品图片地址
     */
    @TableField("pic_path")
    private String picPath;

    @TableField("seller_id")
    private String sellerId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
        ", id=" + id +
        ", itemId=" + itemId +
        ", goodsId=" + goodsId +
        ", orderId=" + orderId +
        ", title=" + title +
        ", price=" + price +
        ", num=" + num +
        ", totalFee=" + totalFee +
        ", picPath=" + picPath +
        ", sellerId=" + sellerId +
        "}";
    }
}
