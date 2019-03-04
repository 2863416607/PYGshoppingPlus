package com.shop.pyg.mapper;

import com.shop.pyg.domain.Specification;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author team
 * @since 2019-02-19
 */
public interface SpecificationMapper extends BaseMapper<Specification> {

    List<Map> selectOptionList();
}
