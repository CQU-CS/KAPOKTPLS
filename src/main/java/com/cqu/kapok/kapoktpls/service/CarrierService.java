package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.dto.CarrierDTO;
import com.cqu.kapok.kapoktpls.entity.Carrier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Carrier)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 09:05:49
 */
public interface CarrierService {

    /**
     * 通过ID查询单条数据
     *
     * @param carrierId 主键
     * @return 实例对象
     */
    Carrier queryById(Integer carrierId);

    /**
     * 分页查询
     *
     * @param carrier 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    Page<Carrier> queryByPage(Carrier carrier, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param carrier 实例对象
     * @return 实例对象
     */
    Carrier insert(Carrier carrier);

    /**
     * 修改数据
     *
     * @param carrier 实例对象
     * @return 实例对象
     */
    Carrier update(Carrier carrier);

    /**
     * 通过主键删除数据
     *
     * @param carrierId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer carrierId);

    List<Carrier> queryAll(CarrierDTO carrierDTO);

    Long getCarrierByConditionCount(Carrier carrier);

}
