package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.entity.RepairRecord;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (RepairRecord)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
public interface RepairRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param repairRecordId 主键
     * @return 实例对象
     */
    RepairRecord queryById(Integer repairRecordId);

    /**
     * 分页查询
     *
     * @param repairRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<RepairRecord> queryByPage(RepairRecord repairRecord, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param repairRecord 实例对象
     * @return 实例对象
     */
    RepairRecord insert(RepairRecord repairRecord);

    /**
     * 修改数据
     *
     * @param repairRecord 实例对象
     * @return 实例对象
     */
    RepairRecord update(RepairRecord repairRecord);

    /**
     * 通过主键删除数据
     *
     * @param repairRecordId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer repairRecordId);

    /**
     * 条件查询
     * @param repairRecord
     * @return
     */
    List<RepairRecord> getByCondition(RepairRecord repairRecord);

}
