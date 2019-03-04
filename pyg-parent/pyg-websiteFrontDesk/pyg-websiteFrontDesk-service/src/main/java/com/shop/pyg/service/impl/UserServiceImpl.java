package com.shop.pyg.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.shop.pyg.domain.Areas;
import com.shop.pyg.mapper.AreasMapper;
import com.shop.pyg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: 陈远明
 * @Date: 2019/2/20 23 : 26
 * @Description:
 */
@Service(timeout = 6000)
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private AreasMapper areasMapper;

    @Override
    public List<Areas> findAllAreas() {
        return this.areasMapper.selectList(null);
    }
}
