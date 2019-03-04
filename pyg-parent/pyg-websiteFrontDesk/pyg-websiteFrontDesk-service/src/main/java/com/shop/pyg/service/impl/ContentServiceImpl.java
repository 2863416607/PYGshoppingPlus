package com.shop.pyg.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.shop.pyg.domain.Content;
import com.shop.pyg.mapper.ContentMapper;
import com.shop.pyg.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @作者: 段清刚
 * @日期时间: 2019/2/279:34
 * @功能描述:广告Service
 * @see
 */
@Service(timeout = 6000)
@Transactional
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentMapper contentMapper;

    @Override
    public List<Content> selectByCategryId(Long categoryId) {
        QueryWrapper<Content> contentQueryWrapper=new QueryWrapper<>();
        QueryWrapper<Content> categoryId1 = contentQueryWrapper.eq("category_id", categoryId)
                .eq("status","1").orderByAsc("sort_order");
        List<Content> contents = this.contentMapper.selectList(categoryId1);

        return contents;
    }


}
