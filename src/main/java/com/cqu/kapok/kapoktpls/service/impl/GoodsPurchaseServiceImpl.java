package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.dto.GoodsPurchaseDTO;
import com.cqu.kapok.kapoktpls.entity.GoodsPurchase;
import com.cqu.kapok.kapoktpls.dao.GoodsPurchaseDao;
import com.cqu.kapok.kapoktpls.service.GoodsPurchaseService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (GoodsPurchase)表服务实现类
 *
 * @author makejava
 * @since 2022-06-28 21:11:50
 */
@Service("goodsPurchaseService")
public class GoodsPurchaseServiceImpl implements GoodsPurchaseService {
    @Resource
    private GoodsPurchaseDao goodsPurchaseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param goodsPurchaseId 主键
     * @return 实例对象
     */
    @Override
    public GoodsPurchase queryById(Integer goodsPurchaseId) {
        return this.goodsPurchaseDao.queryById(goodsPurchaseId);
    }

    /**
     * 分页查询
     *
     * @param goodsPurchase 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<GoodsPurchase> queryByPage(GoodsPurchase goodsPurchase, PageRequest pageRequest) {
        long total = this.goodsPurchaseDao.count(goodsPurchase);
        return new PageImpl<>(this.goodsPurchaseDao.queryAllByLimit(goodsPurchase, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param goodsPurchase 实例对象
     * @return 实例对象
     */
    @Override
    public GoodsPurchase insert(GoodsPurchase goodsPurchase) {
        this.goodsPurchaseDao.insert(goodsPurchase);
        return goodsPurchase;
    }

    /**
     * 修改数据
     *
     * @param goodsPurchase 实例对象
     * @return 实例对象
     */
    @Override
    public GoodsPurchase update(GoodsPurchase goodsPurchase) {
        this.goodsPurchaseDao.update(goodsPurchase);
        return this.queryById(goodsPurchase.getGoodsPurchaseId());
    }

    /**
     * 通过主键删除数据
     *
     * @param goodsPurchaseId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer goodsPurchaseId) {
        return this.goodsPurchaseDao.deleteById(goodsPurchaseId) > 0;
    }

    @Override
    public List<GoodsPurchase> queryAll(GoodsPurchaseDTO goodsPurchaseDTO){
        return this.goodsPurchaseDao.queryAll(goodsPurchaseDTO);
    }

    @Override
    public Long getGoodsPurchaseByConditionCount(GoodsPurchase goodsPurchase) {
        return this.goodsPurchaseDao.getGoodsPurchaseByConditionCount(goodsPurchase);
    }
}
