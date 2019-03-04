package com.shop.pyg.controller.bandcontroller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.shop.pyg.domain.Specification;
import com.shop.pyg.entity.PageResult;
import com.shop.pyg.entity.Result;
import com.shop.pyg.service.SpecificationService;
import com.shop.pyg.vo.SpecificationVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2019-02-20
 */
@RestController
@RequestMapping("/specification")
public class SpecificationController {
    @Reference
    private SpecificationService specificationService;

    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findAll")
    public List<Specification> findAll(){
        return specificationService.findAll();
    }


    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows){
        return specificationService.findPage(page, rows);
    }

    /**
     * 增加
     * @param specification
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody SpecificationVO specification){
        try {
            specificationService.add(specification);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     * @param specification
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody SpecificationVO specification){
        try {
            specificationService.update(specification);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 获取实体
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public SpecificationVO findOne(Long id){
        return specificationService.findOne(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Long [] ids){
        try {
            specificationService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 查询+分页
     * @param brand
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody Specification specification, int page, int rows  ){
        return specificationService.findPage(specification, page, rows);
    }

    @RequestMapping("/selectOptionList")
    public List<Map> selectOptionList(){

        return specificationService.selectOptionList();
    }
}

