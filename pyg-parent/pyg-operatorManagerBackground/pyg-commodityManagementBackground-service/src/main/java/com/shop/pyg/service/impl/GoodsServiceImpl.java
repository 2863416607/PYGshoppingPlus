package com.shop.pyg.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.pyg.domain.Goods;
import com.shop.pyg.domain.Item;
import com.shop.pyg.entity.PageResult;
import com.shop.pyg.mapper.GoodsMapper;
import com.shop.pyg.mapper.ItemMapper;
import com.shop.pyg.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

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
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private ItemMapper itemMapper;

    /**
     * 查询全部
     */
    @Override
    public List<Goods> findAll() {
        return goodsMapper.selectList(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Goods> page = (Page<Goods>) goodsMapper.selectList(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(Goods goods) {
        goodsMapper.insert(goods);
    }


    /**
     * 修改
     */
    @Override
    public void update(Goods goods) {
        goodsMapper.updateById(goods);
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public Goods findOne(Long id) {
        return goodsMapper.selectById(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            goodsMapper.deleteById(id);
        }
    }


    @Override
    public PageResult findPage(Goods goods, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        QueryWrapper wrapper = new QueryWrapper();

        if (goods != null) {
            if (goods.getSellerId() != null && goods.getSellerId().length() > 0) {
                wrapper.like("seller_id", goods.getSellerId());
            }
            if (goods.getGoodsName() != null && goods.getGoodsName().length() > 0) {
                wrapper.like("goods_name", goods.getGoodsName());
            }
            if (goods.getAuditStatus() != null && goods.getAuditStatus().length() > 0) {
                wrapper.like("audit_status", goods.getAuditStatus());
            }
            if (goods.getIsMarketable() != null && goods.getIsMarketable().length() > 0) {
                wrapper.like("is_marketable", goods.getIsMarketable());
            }
            if (goods.getCaption() != null && goods.getCaption().length() > 0) {
                wrapper.like("caption", goods.getCaption());
            }
            if (goods.getSmallPic() != null && goods.getSmallPic().length() > 0) {
                wrapper.like("small_pic", goods.getSmallPic());
            }
            if (goods.getIsEnableSpec() != null && goods.getIsEnableSpec().length() > 0) {
                wrapper.like("is_enable_spec", goods.getIsEnableSpec());
            }
            if (goods.getIsDelete() != null && goods.getIsDelete().length() > 0) {
                wrapper.like("is_delete", goods.getIsDelete());
            }

        }
        Page<Goods> page = (Page<Goods>) goodsMapper.selectList(wrapper);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void updateStatus(Long[] ids, String status) {
        for (Long id : ids) {
            Goods goods = goodsMapper.selectById(id);

            goods.setAuditStatus(status);

            goodsMapper.updateById(goods);
        }
    }
}
