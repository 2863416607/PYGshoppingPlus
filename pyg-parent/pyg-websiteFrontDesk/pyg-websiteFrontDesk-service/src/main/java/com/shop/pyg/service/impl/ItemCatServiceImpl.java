package com.shop.pyg.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shop.pyg.domain.ItemCat;
import com.shop.pyg.mapper.ItemCatMapper;
import com.shop.pyg.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @作者: 段清刚
 * @日期时间: 2019/2/2714:08
 * @功能描述: 商品分类service
 * @see
 */

@Service(timeout = 6000)
@Transactional
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private ItemCatMapper itemCatMapper;

    /*
     *功能描述 查询一级目录
     * @author qqg
     * @date 2019/2/27
     * @param No such property: code for class: Script1
     * @return
     */
    @Override
    public List<ItemCat> selectTop() {
        QueryWrapper<ItemCat> queryWrapper=new QueryWrapper<ItemCat>().eq("parent_id",0l);

        List<ItemCat> itemCats = itemCatMapper.selectList(queryWrapper);

        return itemCats;
    }

    @Override
    public List<ItemCat> selectByParentId(Long id) {
        QueryWrapper<ItemCat> queryWrapper=new QueryWrapper<ItemCat>().eq("parent_id",id);
        List<ItemCat> itemCats = itemCatMapper.selectList(queryWrapper);
        return itemCats;
    }
}
