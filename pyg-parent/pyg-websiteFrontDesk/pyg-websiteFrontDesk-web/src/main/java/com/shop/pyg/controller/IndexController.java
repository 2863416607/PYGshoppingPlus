package com.shop.pyg.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shop.pyg.domain.Content;
import com.shop.pyg.domain.ItemCat;
import com.shop.pyg.service.ContentService;
import com.shop.pyg.service.ItemCatService;
import com.shop.pyg.util.rdeis.RedisUtil;
import com.shop.pyg.vo.ItemCatVo;
import com.shop.pyg.vo.ItemCatVo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @作者: 段清刚
 * @日期时间: 2019/2/2614:26
 * @功能描述:主页面
 * @see
 */


@Controller
@RequestMapping(value = "/index")
public class IndexController {
    @Autowired
    private RedisUtil redisUtil;

    @Reference
    private ContentService contentService;

    @Reference
    private ItemCatService itemCatService;


    @GetMapping(value = {"/index2"})
    public String index(HttpServletRequest request) {
        String substring = request.getServletPath().substring("/index".length());
        return substring;
    }

    /*
     *功能描述 :(轮播图) 根据广告内容id查询广告
     * @author ♋
     * @date 2019/2/28
     * @param No such property: code for class: Script1
     * @return
     */
    @GetMapping(value = "/findByCategoryId")
    @ResponseBody
    public List<Content> findByCategoryId(@RequestParam Long categoryId) {
        List<Content> contents;
        contents = (List<Content>) this.redisUtil.get("contents");
        if (CollectionUtils.isEmpty(contents)){
            contents=new ArrayList<>();
            contents = contentService.selectByCategryId(categoryId);
            this.redisUtil.set("contents",contents);
        }


        return contents;
    }


    /*
     *功能描述 :查询所有商品分类
     * @author qqg
     * @date 2019/2/27
     * @param No such property: code for class: Script1
     * @return
     */
    @GetMapping(value = "/index")
    public ModelAndView selectGoodsList1(ModelAndView modelAndView) {
        List<ItemCatVo> itemCatVos1 = (List<ItemCatVo>) redisUtil.get("itemCatVos");
        /*返回结果集合*/
        List<ItemCatVo> itemCatVos=itemCatVos1;

        if (CollectionUtils.isEmpty(itemCatVos1)){

            /*返回结果集合*/
           itemCatVos=new ArrayList<>();

            /*一级节点*/
            List<ItemCat> parentItemCats = this.itemCatService.selectTop();

            for (ItemCat parentItemCat : parentItemCats) {

                ItemCatVo itemCatVo=new ItemCatVo();
                itemCatVo.setParentItemCat(parentItemCat);

                /*二级节点*/
                List<ItemCat> itemCats = this.itemCatService.selectByParentId(parentItemCat.getId());
                List<ItemCatVo2> itemCatVo2s=new ArrayList<>();
                for (ItemCat itemCat : itemCats) {
                    ItemCatVo2 itemCatVo2=new ItemCatVo2();
                    itemCatVo2.setParenttemCat(itemCat);
                    /*三级节点*/
                    List<ItemCat> itemCats1 = this.itemCatService.selectByParentId(itemCat.getId());
                    itemCatVo2.setItemCats(itemCats1);
                    itemCatVo2s.add(itemCatVo2);
                }

                itemCatVo.setItemCats(itemCatVo2s);
                itemCatVos.add(itemCatVo);

            }

            this.redisUtil.set("itemCatVos",itemCatVos);

        }


        modelAndView.addObject("itemCatVos",itemCatVos);
        modelAndView.setViewName("index");


        return modelAndView;
    }







}
