package com.shop.pyg.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.pyg.domain.Specification;
import com.shop.pyg.domain.SpecificationOption;
import com.shop.pyg.entity.PageResult;
import com.shop.pyg.mapper.SpecificationMapper;
import com.shop.pyg.mapper.SpecificationOptionMapper;
import com.shop.pyg.service.SpecificationService;
import com.shop.pyg.vo.SpecificationVO;
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
public class SpecificationServiceImpl implements SpecificationService {
    @Autowired
    private SpecificationMapper specificationMapper;

    @Autowired
    private SpecificationOptionMapper specificationOptionMapper;

    /**
     * 查询全部
     */
    @Override
    public List<Specification> findAll() {
        return specificationMapper.selectList(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Specification> page = (Page<Specification>) specificationMapper.selectList(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(SpecificationVO specification) {
        //获取规格实体
        Specification Specification = specification.getSpecification();
        specificationMapper.insert(Specification);

        //获取规格选项集合
        List<SpecificationOption> specificationOptionList = specification.getSpecificationOptionList();
        for (SpecificationOption option : specificationOptionList) {
            option.setSpecId(Specification.getId());//设置规格ID
            specificationOptionMapper.insert(option);//新增规格
        }
    }


    /**
     * 修改
     */
    @Override
    public void update(SpecificationVO specification) {

        //获取规格实体
        Specification Specification = specification.getSpecification();
        specificationMapper.updateById(Specification);

        //删除原来规格对应的规格选项	
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("spec_id", Specification.getId());
        specificationOptionMapper.delete(wrapper);

        //获取规格选项集合
        List<SpecificationOption> specificationOptionList = specification.getSpecificationOptionList();
        for (SpecificationOption option : specificationOptionList) {
            option.setSpecId(Specification.getId());//设置规格ID
            specificationOptionMapper.insert(option);//新增规格
        }

    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public SpecificationVO findOne(Long id) {

        SpecificationVO specification = new SpecificationVO();
        //获取规格实体
        Specification Specification = specificationMapper.selectById(id);
        specification.setSpecification(Specification);

        //获取规格选项列表	

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("spec_id", id);
        List<SpecificationOption> specificationOptionList = specificationOptionMapper.selectList(wrapper);

        specification.setSpecificationOptionList(specificationOptionList);

        return specification;//组合实体类
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            //删除规格表数据
            specificationMapper.deleteById(id);

            //删除规格选项表数据		
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("spec_id", id);
            specificationOptionMapper.delete(wrapper);
        }
    }


    @Override
    public PageResult findPage(Specification specification, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        QueryWrapper wrapper = new QueryWrapper();

        if (specification != null) {
            if (specification.getSpecName() != null && specification.getSpecName().length() > 0) {
                wrapper.like("spec_name", specification.getSpecName());
            }

        }

        Page<Specification> page = (Page<Specification>) specificationMapper.selectList(wrapper);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public List<Map> selectOptionList() {
        // TODO Auto-generated method stub
        return specificationMapper.selectOptionList();
//
    }

}
