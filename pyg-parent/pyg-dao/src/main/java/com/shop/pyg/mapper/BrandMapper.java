package com.shop.pyg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shop.pyg.domain.Brand;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2019-02-20
 */
public interface BrandMapper extends BaseMapper<Brand> {

    List<Map> selectOptionList();
}