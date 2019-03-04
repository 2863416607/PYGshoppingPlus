package com.shop.pyg.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.pyg.domain.Content;
import com.shop.pyg.domain.ContentCategory;
import com.shop.pyg.mapper.ContentCategoryMapper;
import com.shop.pyg.mapper.ContentMapper;
import com.shop.pyg.service.AdvertisingManagerService;
import com.shop.pyg.util.rdeis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: 陈远明
 * @Date: 2019/2/21 16 : 01
 * @Description:
 */
@Service(timeout = 10000)
@Transactional
public class AdvertisingManagerServiceImpl implements AdvertisingManagerService {
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ContentMapper contentMapper;

    @Autowired
    private ContentCategoryMapper contentCategoryMapper;

    @Override
    public PageInfo findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Content> contentList = this.contentMapper.selectList(null);
        PageInfo<Content> pageInfo = new PageInfo<>(contentList);
        return pageInfo;
    }

    @Override
    public void deleteContentById(Long id) {
        this.redisUtil.del("contents");
        this.contentMapper.deleteById(id);
    }

    @Override
    public List<ContentCategory> findContentCategory() {
        return this.contentCategoryMapper.selectList(null);
    }

    @Override
    public void saveContent(Content content) {
        this.redisUtil.del("contents");
        this.contentMapper.insert(content);
    }

    @Override
    public void deleteContentByIds(Long[] ids) {
        this.redisUtil.del("contents");
        List list = Arrays.asList(ids);
        this.contentMapper.deleteBatchIds(list);
    }

    @Override
    public void updateContentStatus1(Long[] ids) {
        this.redisUtil.del("contents");
        for (int i = 0; i < ids.length; i++) {
            Content content = this.contentMapper.selectById(ids[i]);
            content.setStatus("1");
            this.contentMapper.updateById(content);
        }
    }

    @Override
    public void updateContentStatus0(Long[] ids) {
        this.redisUtil.del("contents");
        for (int i = 0; i < ids.length; i++) {
            Content content = this.contentMapper.selectById(ids[i]);
            content.setStatus("0");
            this.contentMapper.updateById(content);
        }
    }

    @Override
    public Content findContentById(Long id) {
        return this.contentMapper.selectById(id);
    }

    @Override
    public void updateContent(Content content) {
        this.redisUtil.del("contents");
        this.contentMapper.updateById(content);
    }
}
