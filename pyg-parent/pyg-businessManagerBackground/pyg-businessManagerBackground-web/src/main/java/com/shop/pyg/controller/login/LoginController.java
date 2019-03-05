package com.shop.pyg.controller.login;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shop.pyg.domain.Seller;
import com.shop.pyg.service.SellerService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 陈远明
 * @Date: 2019/3/4 08 : 55
 * @Description:
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Reference
    private SellerService sellerService;


    @GetMapping("/viewLoginName")
    public Seller viewLoginName(){
        String name= SecurityContextHolder.getContext().getAuthentication().getName();

        Seller seller = this.sellerService.findUserByName(name);

        return seller;
    }

}
