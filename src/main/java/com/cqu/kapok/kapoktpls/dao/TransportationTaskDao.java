package com.cqu.kapok.kapoktpls.dao;

import com.cqu.kapok.kapoktpls.dto.ProfitDTO;
import com.cqu.kapok.kapoktpls.dto.TransportationTaskDTO;
import com.cqu.kapok.kapoktpls.entity.TransportationTask;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

/**
 * (TransportationTask)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-28 10:12:34
 */
public interface TransportationTaskDao {

    /**
     * 通过ID查询单条数据
     *
     * @param transportationTaskId 主键
     * @return 实例对象
     */
    TransportationTask queryById(Integer transportationTaskId);

    /**
     * 查询指定行数据
     *
     * @param transportationTask 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TransportationTask> queryAllByLimit(TransportationTask transportationTask, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param transportationTask 查询条件
     * @return 总行数
     */
    long count(TransportationTask transportationTask);

    /**
     * 新增数据
     *
     * @param transportationTask 实例对象
     * @return 影响行数
     */
    int insert(TransportationTask transportationTask);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TransportationTask> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TransportationTask> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TransportationTask> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TransportationTask> entities);

    /**
     * 修改数据
     *
     * @param transportationTask 实例对象
     * @return 影响行数
     */
    int update(TransportationTask transportationTask);

    /**
     * 通过主键删除数据
     *
     * @param transportationTaskId 主键
     * @return 影响行数
     */
    int deleteById(Integer transportationTaskId);

    /**
     *
     *
     * @param transportationTask
     * @return
     */
    List<TransportationTask> queryByTransportationTask(TransportationTask transportationTask);

    /**
     *
     * @param transportationTaskDTO
     * @return
     */
    List<TransportationTask> queryByTransportationTaskDTO(TransportationTaskDTO transportationTaskDTO);

    /**
     *
     * @param transportationTask
     * @return
     */
    Long getTransportationTaskByConditionCount(TransportationTask transportationTask);

    Long getMonthProfit(ProfitDTO profitDTO);

    Long getProfit(Date date);
}

