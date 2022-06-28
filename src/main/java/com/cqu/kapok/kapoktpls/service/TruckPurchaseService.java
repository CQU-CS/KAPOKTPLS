package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.entity.TruckPurchase;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (TruckPurchase)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
public interface TruckPurchaseService {

    /**
     * 通过ID查询单条数据
     *
     * @param truckPurchaseId 主键
     * @return 实例对象
     */
    TruckPurchase queryById(Integer truckPurchaseId);

    /**
     * 分页查询
     *
     * @param truckPurchase 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TruckPurchase> queryByPage(TruckPurchase truckPurchase, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param truckPurchase 实例对象
     * @return 实例对象
     */
    TruckPurchase insert(TruckPurchase truckPurchase);

    /**
     * 修改数据
     *
     * @param truckPurchase 实例对象
     * @return 实例对象
     */
    TruckPurchase update(TruckPurchase truckPurchase);

    /**
     * 通过主键删除数据
     *
     * @param truckPurchaseId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer truckPurchaseId);

    /**
     *
     * @param truckPurchase
     * @return
     */
    DataResult<List<TruckPurchase>> queryByTruck(TruckPurchase truckPurchase);
}
