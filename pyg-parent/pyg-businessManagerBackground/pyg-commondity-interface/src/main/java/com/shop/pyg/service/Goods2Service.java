package com.shop.pyg.service;

import com.github.pagehelper.PageInfo;
import com.shop.pyg.domain.Goods;

import java.util.List;

/**
 * @Auther: 陈亮慧
 * @Date: 2019/2/25
 * @Description:
 */
public interface Goods2Service {

    /**
     * 查询全部
     * @return
     */
    List<Goods> findAll();

    /**
     * 品牌分页
     * @param pageNum 当前页码
     * @param pageSize 每页记录数
     * @return
     */
    public PageInfo findPage(Integer pageNum, Integer pageSize,Goods goods);


    public void delete(Long[] ids);

    /**
     * 根据ID获取实体
     * @param id
     * @return
     */
    public Goods findOne(Goods id);

    /**
     * 增加
     */
    public void add(Goods goods);

    public String selectByLikeName(Goods goodsName);


    void updateStatus(Long[] ids, String status);
}
