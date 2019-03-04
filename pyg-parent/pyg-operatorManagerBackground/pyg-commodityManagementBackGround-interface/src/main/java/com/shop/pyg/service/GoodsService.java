package com.shop.pyg.service;

import com.shop.pyg.domain.Goods;
import com.shop.pyg.entity.PageResult;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2019-02-20
 */
public interface GoodsService {
    /**
     * 返回全部列表
     * @return
     */
    public List<Goods> findAll();


    /**
     * 返回分页列表
     * @return
     */
    public PageResult findPage(int pageNum, int pageSize);


    /**
     * 增加
     */
    public void add(Goods goods);


    /**
     * 修改
     */
    public void update(Goods goods);


    /**
     * 根据ID获取实体
     * @param id
     * @return
     */
    public Goods findOne(Long id);


    /**
     * 批量删除
     * @param ids
     */
    public void delete(Long[] ids);

    /**
     * 分页
     * @param pageNum 当前页 码
     * @param pageSize 每页记录数
     * @return
     */
    public PageResult findPage(Goods goods, int pageNum, int pageSize);

    public void updateStatus(Long[] ids, String status);
}
