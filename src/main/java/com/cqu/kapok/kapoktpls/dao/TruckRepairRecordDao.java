package com.cqu.kapok.kapoktpls.dao;

import com.cqu.kapok.kapoktpls.dto.TruckRepairRecordDTO;
import com.cqu.kapok.kapoktpls.entity.TruckRepairRecord;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TruckRepairRecord)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
public interface TruckRepairRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param truckRepairRecordId 主键
     * @return 实例对象
     */
    TruckRepairRecord queryById(Integer truckRepairRecordId);

    /**
     * 查询指定行数据
     *
     * @param truckRepairRecord 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TruckRepairRecord> queryAllByLimit(TruckRepairRecord truckRepairRecord, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param truckRepairRecord 查询条件
     * @return 总行数
     */
    long count(TruckRepairRecord truckRepairRecord);

    /**
     * 新增数据
     *
     * @param truckRepairRecord 实例对象
     * @return 影响行数
     */
    int insert(TruckRepairRecord truckRepairRecord);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TruckRepairRecord> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TruckRepairRecord> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TruckRepairRecord> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TruckRepairRecord> entities);

    /**
     * 修改数据
     *
     * @param truckRepairRecord 实例对象
     * @return 影响行数
     */
    int update(TruckRepairRecord truckRepairRecord);

    /**
     * 通过主键删除数据
     *
     * @param truckRepairRecordId 主键
     * @return 影响行数
     */
    int deleteById(Integer truckRepairRecordId);

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

