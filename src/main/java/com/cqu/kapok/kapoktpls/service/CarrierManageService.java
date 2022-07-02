package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.dto.CarrierManageDTO;
import com.cqu.kapok.kapoktpls.entity.Carrier;
import com.cqu.kapok.kapoktpls.entity.CarrierManage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

/**
 * (CarrierManage)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 10:46:14
 */
public interface CarrierManageService {

    /**
     * 通过ID查询单条数据
     *
     * @param carrierManageId 主键
     * @return 实例对象
     */
    CarrierManage queryById(Integer carrierManageId);

    /**
     * 分页查询
     *
     * @param carrierManage 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<CarrierManage> queryByPage(CarrierManage carrierManage, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param carrierManage 实例对象
     * @return 实例对象
     */
    CarrierManage insert(CarrierManage carrierManage);

    /**
     * 修改数据
     *
     * @param carrierManage 实例对象
     * @return 实例对象
     */
    CarrierManage update(CarrierManage carrierManage);

    /**
     * 通过主键删除数据
     *
     * @param carrierManageId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer carrierManageId);
    List<CarrierManage> queryAll(CarrierManageDTO carrierManageDTO);

    Long getCarrierMangeByConditionCount(CarrierManage carrierManage);

    /**
     * 获取本月支出
     * @param date
     * @return
     */
    Long getMonthPrice(Date date);

}
