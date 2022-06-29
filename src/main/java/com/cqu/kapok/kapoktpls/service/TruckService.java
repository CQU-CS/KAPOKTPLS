package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.dto.TruckDTO;
import com.cqu.kapok.kapoktpls.entity.Truck;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Truck)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
public interface TruckService {

    /**
     * 通过ID查询单条数据
     *
     * @param truckId 主键
     * @return 实例对象
     */
    Truck queryById(Integer truckId);

    /**
     * 分页查询
     *
     * @param truck 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Truck> queryByPage(Truck truck, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param truck 实例对象
     * @return 实例对象
     */
    Truck insert(Truck truck);

    /**
     * 修改数据
     *
     * @param truck 实例对象
     * @return 实例对象
     */
    Truck update(Truck truck);

    /**
     * 通过主键删除数据
     *
     * @param truckId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer truckId);

    /**
     * 查询全部
     *
     * @param truck
     * @return
     */
    List<Truck> queryByTruck(Truck truck);

    /**
     *
     * @param truckDTO
     * @return
     */
    List<Truck> queryByTruckDTO(TruckDTO truckDTO);

    /**
     *
     * @param truck
     * @return
     */
    Long getTruckByConditionCount(Truck truck);
}
