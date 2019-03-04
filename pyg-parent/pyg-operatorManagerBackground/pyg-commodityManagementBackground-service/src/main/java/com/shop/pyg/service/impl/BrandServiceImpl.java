package com.shop.pyg.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.pyg.domain.Brand;
import com.shop.pyg.entity.PageResult;
import com.shop.pyg.mapper.BrandMapper;
import com.shop.pyg.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 王德胜
 * @since 2019-02-20
 */
@Service(timeout = 6000)
@Transactional
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return this.brandMapper.selectList(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Brand> page = (Page<Brand>) brandMapper.selectList(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void add(Brand brand) {
        this.brandMapper.insert(brand);
    }


    @Override
    public void update(Brand brand) {
        this.brandMapper.updateById(brand);
    }

    @Override
    public Brand findOne(Long id) {
        return this.brandMapper.selectById(id);
    }


    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            brandMapper.deleteById(id);
        }
    }

    @Override
    public PageResult findPage(Brand brand, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        QueryWrapper wrapper = new QueryWrapper();
        if (brand != null) {
            if (brand.getName() != null && brand.getName().length() > 0) {
                wrapper.like("name", brand.getName());
            }
            if (brand.getFirstChar() != null && brand.getFirstChar().length() > 0) {
                wrapper.like("first_char", brand.getFirstChar());
            }

        }

        Page<Brand> page = (Page<Brand>) brandMapper.selectList(wrapper);
        return new PageResult(page.getTotal(), page.getResult());
    }


    @Override
    public  List<Map> selectOptionList() {
        return this.brandMapper.selectOptionList();
    }
}
