package com.shop.pyg.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.pyg.domain.ContentCategory;
import com.shop.pyg.mapper.ContentCategoryMapper;
import com.shop.pyg.service.ContentCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.pyg.util.rdeis.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 内容分类 服务实现类
 * </p>
 *
 * @author team
 * @since 2019-02-25
 */
@Service (timeout = 6000)
@Transactional
public class ContentCategoryServiceImpl implements ContentCategoryService {


    @Autowired
    private ContentCategoryMapper contentCategoryMapper;


    /**
     * 广告管理查询所有方法
     * @return
     */
    @Override
    public List<ContentCategory> findAll() {
        return this.contentCategoryMapper.selectList(null);
    }


    /**
     * 广告分类管理分页查询+按条件查询方法实现
     * @param contentCategory
     * @return
     */
    @Override
    public PageInfo<ContentCategory> findAllContentCategory(ContentCategory contentCategory, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        QueryWrapper<ContentCategory> queryWrapper = new QueryWrapper<ContentCategory>();

        if(StringUtils.isNotBlank(contentCategory.getName())&&contentCategory.getName()!="undefined"){
            queryWrapper.like("name",contentCategory.getName());
        }
         List<ContentCategory> list = this.contentCategoryMapper.selectList(queryWrapper);

        return new PageInfo<>(list);

    }

    /**
     * 广告分类管理修改方法
     * @return
     */
    @Override
    public int updateContentCategory(ContentCategory contentCategory) {

        return this.contentCategoryMapper.updateById(contentCategory);
    }


    /**
     * 广告分类管理添加方法
     * @param contentCategory
     * @return
     */
    @Override
    public int insertContentCategory(ContentCategory contentCategory) {
        return this.contentCategoryMapper.insert(contentCategory);
    }


    /**
     * 广告分类管理根据Id查询一条数据
     * @param contentCategory
     * @return
     */

    @Override
    public ContentCategory selectByidContentCategory(Long id) {
        return this.contentCategoryMapper.selectById(id);
    }

    /**
     * 广告分类管理删除一条或者多条方法
     * @param contentCategory
     * @return
     */

    @Override
    public void delete(Long[] listid) {
        for (Long id : listid) {
            contentCategoryMapper.deleteById(id);
        }
    }

    @Override
    public void updateContentStatus1(Long[] ids) {
        for (int i = 0; i < ids.length; i++) {
            ContentCategory contentCategory = this.contentCategoryMapper.selectById(ids[i]);
            contentCategory.setState("1");
            this.contentCategoryMapper.updateById(contentCategory);
        }
    }

    @Override
    public void updateContentStatus0(Long[] ids) {
        for (int i = 0; i < ids.length; i++) {
            ContentCategory content = this.contentCategoryMapper.selectById(ids[i]);
            content.setState("0");
            this.contentCategoryMapper.updateById(content);
        }
    }
}
