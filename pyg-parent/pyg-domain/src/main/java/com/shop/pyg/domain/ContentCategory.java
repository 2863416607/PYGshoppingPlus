package com.shop.pyg.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 内容分类
 * </p>
 *
 * @author team
 * @since 2019-02-25
 */
@TableName("tb_content_category")
public class ContentCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类目ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * key
     */
    private String contentkey;

    /**
     * 分组
     */
    private String grouping;

    /**
     * 状态
     */
    private String state;


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

    public String getContentkey() {
        return contentkey;
    }

    public void setContentkey(String contentkey) {
        this.contentkey = contentkey;
    }

    public String getGrouping() {
        return grouping;
    }

    public void setGrouping(String grouping) {
        this.grouping = grouping;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "contentcategory{" +
        ", id=" + id +
        ", name=" + name +
        ", contentkey=" + contentkey +
        ", grouping=" + grouping +
        ", state=" + state +
        "}";
    }
}
