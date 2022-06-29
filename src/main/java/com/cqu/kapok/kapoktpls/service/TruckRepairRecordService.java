package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.dto.TruckRepairRecordDTO;
import com.cqu.kapok.kapoktpls.entity.TruckRepairRecord;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (TruckRepairRecord)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
public interface TruckRepairRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param truckRepairRecordId 主键
     * @return 实例对象
     */
    TruckRepairRecord queryById(Integer truckRepairRecordId);

    /**
     * 分页查询
     *
     * @param truckRepairRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TruckRepairRecord> queryByPage(TruckRepairRecord truckRepairRecord, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param truckRepairRecord 实例对象
     * @return 实例对象
     */
    TruckRepairRecord insert(TruckRepairRecord truckRepairRecord);

    /**
     * 修改数据
     *
     * @param truckRepairRecord 实例对象
     * @return 实例对象
     */
    TruckRepairRecord update(TruckRepairRecord truckRepairRecord);

    /**
     * 通过主键删除数据
     *
     * @param truckRepairRecordId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer truckRepairRecordId);

    /**
     *
     * @param truckRepairRecord
     * @return
     */
    List<TruckRepairRecord> queryByTruckRepairRecord(TruckRepairRecord truckRepairRecord);

    /**
     *
     * @param truckRepairRecordDTO
     * @return
     */
    List<TruckRepairRecord> queryByTruckRepairRecordDTO(TruckRepairRecordDTO truckRepairRecordDTO);

    /**
     *
     * @param truckRepairRecord
     * @return
     */
    Long getTruckRepairRecordByConditionCount(TruckRepairRecord truckRepairRecord);
}
