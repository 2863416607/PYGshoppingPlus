package com.shop.pyg.controller.seller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.shop.pyg.domain.Seller;
import com.shop.pyg.service.SellerService;
import com.shop.pyg.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;

/**
 * @Auther: 黄军
 * @Date: 2019/2/22 11 : 36
 * @Description:
 */
@Controller
@RequestMapping("/seller")
public class SellerController {

    @Reference
    private SellerService sellerService;


    @RequestMapping(value = "/findBusinessreview", method = RequestMethod.POST)
    @ResponseBody
    public PageInfo<Seller> findBusinessreview(@RequestBody Seller seller,@RequestParam int page,
                                       @RequestParam int rows) {
            PageInfo<Seller> pageinfo = null;
        try {
            pageinfo = this.sellerService.querypage(seller, page, rows);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return pageinfo;
    }

    @RequestMapping(value = "/findBusinessmanagement", method = RequestMethod.POST)
    @ResponseBody
    public PageInfo<Seller> findBusinessmanagement(@RequestBody Seller seller,String status,@RequestParam int page, @RequestParam int rows) {
        PageInfo<Seller> pageinfo = null;

        try {
            pageinfo = this.sellerService.querypage1(seller, page, rows,status);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return pageinfo;
    }


    @GetMapping(value = "/queryparticulars")
    @ResponseBody
    public Seller particulars(ServletRequest request) {
        String id = request.getParameter("id");
        Seller seller1 = null;

        seller1 = new Seller();
        seller1 = this.sellerService.querybyid(id);

        return seller1;
    }


    /**
     * 审核商家入驻
     * @param seller
     * @return
     */

    @GetMapping(value = "/changestatus")
    @ResponseBody
    public ResultVO changestatus(Seller seller) {

        ResultVO resultVO=new ResultVO();

        try {
            this.sellerService.changestatus(seller);
            resultVO.setFlag(1);
            resultVO.setMessage("处理成功");
        } catch (Exception e) {
            resultVO.setFlag(0);
            resultVO.setMessage("处理失败");
            e.printStackTrace();
        }

        return resultVO;
    }

}
