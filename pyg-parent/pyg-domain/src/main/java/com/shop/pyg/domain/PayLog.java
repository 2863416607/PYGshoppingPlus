package com.shop.pyg.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author team
 * @since 2019-02-19
 */
@TableName("tb_pay_log")
public class PayLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 支付订单号
     */
    @TableId("out_trade_no")
    private String outTradeNo;

    /**
     * 创建日期
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 支付完成时间
     */
    @TableField("pay_time")
    private LocalDateTime payTime;

    /**
     * 支付金额（分）
     */
    @TableField("total_fee")
    private Long totalFee;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private String userId;

    /**
     * 交易号码
     */
    @TableField("transaction_id")
    private String transactionId;

    /**
     * 交易状态
     */
    @TableField("trade_state")
    private String tradeState;

    /**
     * 订单编号列表
     */
    @TableField("order_list")
    private String orderList;

    /**
     * 支付类型
     */
    @TableField("pay_type")
    private String payType;


    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getPayTime() {
        return payTime;
    }

    public void setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
    }

    public Long getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTradeState() {
        return tradeState;
    }

    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
    }

    public String getOrderList() {
        return orderList;
    }

    public void setOrderList(String orderList) {
        this.orderList = orderList;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    @Override
    public String toString() {
        return "PayLog{" +
        ", outTradeNo=" + outTradeNo +
        ", createTime=" + createTime +
        ", payTime=" + payTime +
        ", totalFee=" + totalFee +
        ", userId=" + userId +
        ", transactionId=" + transactionId +
        ", tradeState=" + tradeState +
        ", orderList=" + orderList +
        ", payType=" + payType +
        "}";
    }
}
