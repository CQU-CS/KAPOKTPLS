package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.entity.TruckPurchase;
import com.cqu.kapok.kapoktpls.dao.TruckPurchaseDao;
import com.cqu.kapok.kapoktpls.service.TruckPurchaseService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TruckPurchase)表服务实现类
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
@Service("truckPurchaseService")
public class TruckPurchaseServiceImpl implements TruckPurchaseService {
    @Resource
    private TruckPurchaseDao truckPurchaseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param truckPurchaseId 主键
     * @return 实例对象
     */
    @Override
    public TruckPurchase queryById(Integer truckPurchaseId) {
        return this.truckPurchaseDao.queryById(truckPurchaseId);
    }

    /**
     * 分页查询
     *
     * @param truckPurchase 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TruckPurchase> queryByPage(TruckPurchase truckPurchase, PageRequest pageRequest) {
        long total = this.truckPurchaseDao.count(truckPurchase);
        return new PageImpl<>(this.truckPurchaseDao.queryAllByLimit(truckPurchase, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param truckPurchase 实例对象
     * @return 实例对象
     */
    @Override
    public TruckPurchase insert(TruckPurchase truckPurchase) {
        this.truckPurchaseDao.insert(truckPurchase);
        return truckPurchase;
    }

    /**
     * 修改数据
     *
     * @param truckPurchase 实例对象
     * @return 实例对象
     */
    @Override
    public TruckPurchase update(TruckPurchase truckPurchase) {
        this.truckPurchaseDao.update(truckPurchase);
        return this.queryById(truckPurchase.getTruckPurchaseId());
    }

    /**
     * 通过主键删除数据
     *
     * @param truckPurchaseId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer truckPurchaseId) {
        return this.truckPurchaseDao.deleteById(truckPurchaseId) > 0;
    }

    @Override
    public DataResult<List<TruckPurchase>> queryByTruck(TruckPurchase truckPurchase) {
        return this.truckPurchaseDao.queryByTruckPurchase(truckPurchase);
    }
}
