package com.shop.pyg.service;

import com.github.pagehelper.PageInfo;
import com.shop.pyg.domain.Content;
import com.shop.pyg.domain.ContentCategory;

import java.util.List;

/**
 * @Auther: 陈远明
 * @Date: 2019/2/21 15 : 57
 * @Description:
 */
public interface AdvertisingManagerService {

    Content findContentById(Long id);

    PageInfo findPage(int pageNum, int pageSize);

    void deleteContentById(Long id);

    List<ContentCategory> findContentCategory();

    void saveContent(Content content);

    void deleteContentByIds(Long[] ids);

    void updateContentStatus1(Long[] ids);

    void updateContentStatus0(Long[] ids);

    void updateContent(Content content);
}
