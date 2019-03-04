package com.shop.pyg.service;

import com.shop.pyg.domain.Content;

import java.util.List;

/**
 * @作者: 段清刚
 * @日期时间: 2019/2/279:35
 * @功能描述:
 * @see
 */
public interface ContentService {
    List<Content> selectByCategryId(Long categoryId);
}
