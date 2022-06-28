package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.entity.TruckSale;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (TruckSale)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
public interface TruckSaleService {

    /**
     * 通过ID查询单条数据
     *
     * @param truckSaleId 主键
     * @return 实例对象
     */
    TruckSale queryById(Integer truckSaleId);

    /**
     * 分页查询
     *
     * @param truckSale 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TruckSale> queryByPage(TruckSale truckSale, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param truckSale 实例对象
     * @return 实例对象
     */
    TruckSale insert(TruckSale truckSale);

    /**
     * 修改数据
     *
     * @param truckSale 实例对象
     * @return 实例对象
     */
    TruckSale update(TruckSale truckSale);

    /**
     * 通过主键删除数据
     *
     * @param truckSaleId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer truckSaleId);

    /**
     *
     * @param truckSale
     * @return
     */
    DataResult<List<TruckSale>> queryByTruckSale(TruckSale truckSale);
}
