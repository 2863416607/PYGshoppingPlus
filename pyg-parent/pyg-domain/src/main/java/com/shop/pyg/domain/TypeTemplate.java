package com.shop.pyg.domain;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("tb_type_template")
public class TypeTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 模板名称
     */
    private String name;

    /**
     * 关联规格
     */
    @TableField("spec_ids")
    private String specIds;

    /**
     * 关联品牌
     */
    @TableField("brand_ids")
    private String brandIds;

    /**
     * 自定义属性
     */
    @TableField("custom_attribute_items")
    private String customAttributeItems;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecIds() {
        return specIds;
    }

    public void setSpecIds(String specIds) {
        this.specIds = specIds;
    }

    public String getBrandIds() {
        return brandIds;
    }

    public void setBrandIds(String brandIds) {
        this.brandIds = brandIds;
    }

    public String getCustomAttributeItems() {
        return customAttributeItems;
    }

    public void setCustomAttributeItems(String customAttributeItems) {
        this.customAttributeItems = customAttributeItems;
    }

    @Override
    public String toString() {
        return "TypeTemplate{" +
        ", id=" + id +
        ", name=" + name +
        ", specIds=" + specIds +
        ", brandIds=" + brandIds +
        ", customAttributeItems=" + customAttributeItems +
        "}";
    }
}
