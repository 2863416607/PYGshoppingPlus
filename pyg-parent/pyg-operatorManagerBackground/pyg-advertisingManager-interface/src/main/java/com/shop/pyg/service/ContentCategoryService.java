package com.shop.pyg.service;

import com.github.pagehelper.PageInfo;
import com.shop.pyg.domain.ContentCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 内容分类 服务类
 * </p>
 *
 * @author team
 * @since 2019-02-25
 */
public interface ContentCategoryService {



    /**
     * 广告分类管理查询全部接口
     * @return
     */
    public List<ContentCategory> findAll();


    /**
     * 广告分类管理分页查询+按条件查询方法实现
     * @param contentCategory
     * @return
     */
    public PageInfo<ContentCategory> findAllContentCategory(ContentCategory contentCategory, int pageNum, int pageSize);


    /**
     * 广告分类管理修改接口
     * @param contentCategory
     * @return
     */
    public int updateContentCategory(ContentCategory contentCategory);

    /**
     * 广告分类管理添加接口
     * @param contentCategory
     * @return
     */
    public int insertContentCategory(ContentCategory contentCategory);

    /**
     * 广告分类管理根据ID查询一条数据接口
     * @param contentCategory
     * @return
     */
    public ContentCategory selectByidContentCategory(Long id);

    /**
     * 广告分类删除多条或者单条数据接口
     * @param listid
     */

    public void delete(Long[] listid);


    void updateContentStatus0(Long[] ids);

    void updateContentStatus1(Long[] ids);
}
