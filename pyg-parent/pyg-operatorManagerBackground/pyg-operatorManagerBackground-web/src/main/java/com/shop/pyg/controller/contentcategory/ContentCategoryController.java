package com.shop.pyg.controller.contentcategory;


import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.shop.pyg.domain.ContentCategory;
import com.shop.pyg.service.ContentCategoryService;
import com.shop.pyg.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 内容分类 前端控制器
 * </p>
 *
 * @author team
 * @since 2019-02-25
 */
@RestController
@RequestMapping("/contentCategory")
public class ContentCategoryController {
    @Reference(timeout = 6000)
    private ContentCategoryService contentCategoryService;


    /**
     * 分页
     *
     * @param page
     * @param rows
     * @param contentCategory
     * @return
     */
    @RequestMapping(value = "/findAll",method = RequestMethod.POST)
    @ResponseBody
    public PageInfo<ContentCategory> findAll(
            @RequestBody ContentCategory contentCategory ,int page, int rows) {


        PageInfo<ContentCategory> pageInfo = this.contentCategoryService.findAllContentCategory(contentCategory, page, rows);
        return pageInfo;


    }


    /**
     * 添加方法
     *
     * @param contentCategory
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public ResultVO add(@RequestBody ContentCategory contentCategory) {

        ResultVO resultVO = new ResultVO();
        try {
            this.contentCategoryService.insertContentCategory(contentCategory);
            resultVO.setFlag(1);
            resultVO.setMessage("添加成功");
        } catch (Exception e) {
            resultVO.setFlag(0);
            resultVO.setMessage("添加失败");
            e.printStackTrace();
        }
        return resultVO;

    }

    /**
     * 删除方法
     *
     * @param id
     * @return
     */
    @GetMapping("/delete")
    @ResponseBody
    public ResultVO delete(Long[] id) {

        ResultVO resultVO = new ResultVO();
        try {
            this.contentCategoryService.delete(id);
            resultVO.setFlag(1);
            resultVO.setMessage("删除成功");
        } catch (Exception e) {
            resultVO.setFlag(0);
            resultVO.setMessage("删除失败");
            e.printStackTrace();
        }

        return resultVO;

    }

    /**
     * 修改方法
     *
     * @param contentCategory
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public ResultVO update(@RequestBody ContentCategory contentCategory) {
        ResultVO resultVO = new ResultVO();
        try {
            this.contentCategoryService.updateContentCategory(contentCategory);
            resultVO.setFlag(1);
            resultVO.setMessage("修改成功");
        } catch (Exception e) {
            resultVO.setFlag(0);
            resultVO.setMessage("修改失败");
            e.printStackTrace();
        }
        return resultVO;

    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    @GetMapping("/selectByia")
    @ResponseBody
    public ContentCategory selectByia(Long id) {
        return this.contentCategoryService.selectByidContentCategory(id);
    }


    @GetMapping("/index")
    public String index(ContentCategory contentCategory) {
        return "admin/index";
    }

    @GetMapping("/content_category")
    public String content(ContentCategory contentCategory) {
        return "admin/content_category";
    }

    @GetMapping("/home")
    public String home(ContentCategory contentCategory) {
        return "home";
    }

    @GetMapping("/updateContentStatus0")
    public ResultVO updateContentStatus0(Long[] ids) {
        ResultVO resultVO = new ResultVO();
        try {
            this.contentCategoryService.updateContentStatus0(ids);
            resultVO.setFlag(1);
            resultVO.setMessage("屏蔽成功");
        } catch (Exception e) {
            resultVO.setFlag(0);
            resultVO.setMessage("屏蔽失败");
            e.printStackTrace();
        }
        return resultVO;
    }

    @GetMapping("/updateContentStatus1")
    public ResultVO updateContentStatus1(Long[] ids) {
        ResultVO resultVO = new ResultVO();
        try {
            this.contentCategoryService.updateContentStatus1(ids);
            resultVO.setFlag(1);
            resultVO.setMessage("开启成功");
        } catch (Exception e) {
            resultVO.setFlag(0);
            resultVO.setMessage("开启失败");
            e.printStackTrace();
        }

        return resultVO;

    }


}



