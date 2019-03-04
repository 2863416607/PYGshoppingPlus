package com.shop.pyg.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author team
 * @since 2019-02-19
 */
@TableName("tb_seller")
public class Seller implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId("seller_id")
    private String sellerId;

    /**
     * 公司名
     */
    private String name;

    /**
     * 店铺名称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 密码
     */
    private String password;

    /**
     * EMAIL
     */
    private String email;

    /**
     * 公司手机
     */
    private String mobile;

    /**
     * 公司电话
     */
    private String telephone;

    /**
     * 状态
     */
    private String status;

    /**
     * 详细地址
     */
    @TableField("address_detail")
    private String addressDetail;

    /**
     * 联系人姓名
     */
    @TableField("linkman_name")
    private String linkmanName;

    /**
     * 联系人QQ
     */
    @TableField("linkman_qq")
    private String linkmanQq;

    /**
     * 联系人电话
     */
    @TableField("linkman_mobile")
    private String linkmanMobile;

    /**
     * 联系人EMAIL
     */
    @TableField("linkman_email")
    private String linkmanEmail;

    /**
     * 营业执照号
     */
    @TableField("license_number")
    private String licenseNumber;

    /**
     * 税务登记证号
     */
    @TableField("tax_number")
    private String taxNumber;

    /**
     * 组织机构代码
     */
    @TableField("org_number")
    private String orgNumber;

    /**
     * 公司地址
     */
    private Long address;

    /**
     * 公司LOGO图
     */
    @TableField("logo_pic")
    private String logoPic;

    /**
     * 简介
     */
    private String brief;

    /**
     * 创建日期
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 法定代表人
     */
    @TableField("legal_person")
    private String legalPerson;

    /**
     * 法定代表人身份证
     */
    @TableField("legal_person_card_id")
    private String legalPersonCardId;

    /**
     * 开户行账号名称
     */
    @TableField("bank_user")
    private String bankUser;

    /**
     * 开户行
     */
    @TableField("bank_name")
    private String bankName;

    @TableField("last_login_time")
    private Date lastLoginTime;


    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getLinkmanName() {
        return linkmanName;
    }

    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName;
    }

    public String getLinkmanQq() {
        return linkmanQq;
    }

    public void setLinkmanQq(String linkmanQq) {
        this.linkmanQq = linkmanQq;
    }

    public String getLinkmanMobile() {
        return linkmanMobile;
    }

    public void setLinkmanMobile(String linkmanMobile) {
        this.linkmanMobile = linkmanMobile;
    }

    public String getLinkmanEmail() {
        return linkmanEmail;
    }

    public void setLinkmanEmail(String linkmanEmail) {
        this.linkmanEmail = linkmanEmail;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getOrgNumber() {
        return orgNumber;
    }

    public void setOrgNumber(String orgNumber) {
        this.orgNumber = orgNumber;
    }

    public Long getAddress() {
        return address;
    }

    public void setAddress(Long address) {
        this.address = address;
    }

    public String getLogoPic() {
        return logoPic;
    }

    public void setLogoPic(String logoPic) {
        this.logoPic = logoPic;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getLegalPersonCardId() {
        return legalPersonCardId;
    }

    public void setLegalPersonCardId(String legalPersonCardId) {
        this.legalPersonCardId = legalPersonCardId;
    }

    public String getBankUser() {
        return bankUser;
    }

    public void setBankUser(String bankUser) {
        this.bankUser = bankUser;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "sellerId='" + sellerId + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", telephone='" + telephone + '\'' +
                ", status='" + status + '\'' +
                ", addressDetail='" + addressDetail + '\'' +
                ", linkmanName='" + linkmanName + '\'' +
                ", linkmanQq='" + linkmanQq + '\'' +
                ", linkmanMobile='" + linkmanMobile + '\'' +
                ", linkmanEmail='" + linkmanEmail + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", taxNumber='" + taxNumber + '\'' +
                ", orgNumber='" + orgNumber + '\'' +
                ", address=" + address +
                ", logoPic='" + logoPic + '\'' +
                ", brief='" + brief + '\'' +
                ", createTime=" + createTime +
                ", legalPerson='" + legalPerson + '\'' +
                ", legalPersonCardId='" + legalPersonCardId + '\'' +
                ", bankUser='" + bankUser + '\'' +
                ", bankName='" + bankName + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}
