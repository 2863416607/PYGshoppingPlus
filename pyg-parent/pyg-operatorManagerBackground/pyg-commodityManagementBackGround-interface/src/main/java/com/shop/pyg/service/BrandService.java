package com.shop.pyg.service;


import com.shop.pyg.domain.Brand;
import com.shop.pyg.entity.PageResult;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author
 * @since 2019-02-20
 */
public interface BrandService {

    /**
     * 返回全部列表
     * @return
     */
    public List<Brand> findAll();


    /**
     * 返回分页列表
     * @return
     */
    public PageResult findPage(int pageNum, int pageSize);


    /**
     * 增加
     */
    public void add(Brand brand);


    /**
     * 修改
     */
    public void update(Brand brand);


    /**
     * 根据ID获取实体
     * @param id
     * @return
     */
    public Brand findOne(Long id);


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
    public PageResult findPage(Brand brand, int pageNum, int pageSize);

    /**
     * 返回下拉列表数据
     * @return
     */
    public  List<Map> selectOptionList();

}
