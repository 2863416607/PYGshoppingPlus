package com.shop.pyg.service;


import com.shop.pyg.domain.Specification;
import com.shop.pyg.entity.PageResult;
import com.shop.pyg.vo.SpecificationVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2019-02-20
 */
public interface SpecificationService {
    /**
     * 返回全部列表
     * @return
     */
    public List<Specification> findAll();


    /**
     * 返回分页列表
     * @return
     */
    public PageResult findPage(int pageNum, int pageSize);


    /**
     * 增加
     */
    public void add(SpecificationVO specificationVO);


    /**
     * 修改
     */
    public void update(SpecificationVO specificationVO);


    /**
     * 根据ID获取实体
     * @param id
     * @return
     */
    public SpecificationVO findOne(Long id);


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
    public PageResult findPage(Specification specification, int pageNum, int pageSize);


    public List<Map> selectOptionList();


}
