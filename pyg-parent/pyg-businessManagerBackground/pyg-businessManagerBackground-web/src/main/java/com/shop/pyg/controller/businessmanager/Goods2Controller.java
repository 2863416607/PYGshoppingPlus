package com.shop.pyg.controller.businessmanager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.shop.pyg.domain.Goods;
import com.shop.pyg.service.Goods2Service;
import com.shop.pyg.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: 陈亮慧
 * @Date: 2019/2/25
 * @Description:
 */

@RestController
@RequestMapping("/goods")
public class Goods2Controller {

    @Reference
    private Goods2Service goodsService;


    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @PostMapping("/search")
    public PageInfo<Goods> search( @RequestParam(value = "page", defaultValue = "1") Integer pageNum, @RequestParam(value = "rows", defaultValue = "5") Integer pageSize,@RequestBody Goods goods) {
        return this.goodsService.findPage(pageNum, pageSize,goods);
    }

    @GetMapping("/delete")
    public ResultVO delete(Long[] ids) {

        ResultVO resultVO = new ResultVO();
        try {
            this.goodsService.delete(ids);
            resultVO.setFlag(1);
            resultVO.setMessage("删除成功");
        } catch (Exception e) {
            resultVO.setFlag(1);
            resultVO.setMessage("删除失败");
            e.printStackTrace();
        }

        return resultVO;
    }

    @GetMapping("/updateStatus")
    public ResultVO updateStatus(Long[] ids, String status) {
        ResultVO resultVO = new ResultVO();
        try {
            this.goodsService.updateStatus(ids, status);
            resultVO.setFlag(1);
            resultVO.setMessage("提交成功");
        } catch (Exception e) {
            resultVO.setFlag(1);
            resultVO.setMessage("提交失败");
            e.printStackTrace();
        }
        return resultVO;
    }


}
