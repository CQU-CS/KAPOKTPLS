package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.dto.ProfitDTO;
import com.cqu.kapok.kapoktpls.dto.TransportationTaskDTO;
import com.cqu.kapok.kapoktpls.entity.TransportationTask;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (TransportationTask)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
public interface TransportationTaskService {

    /**
     * 通过ID查询单条数据
     *
     * @param transportationTaskId 主键
     * @return 实例对象
     */
    TransportationTask queryById(Integer transportationTaskId);



    /**
     * 分页查询
     *
     * @param transportationTask 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TransportationTask> queryByPage(TransportationTask transportationTask, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param transportationTask 实例对象
     * @return 实例对象
     */
    TransportationTask insert(TransportationTask transportationTask);

    /**
     * 修改数据
     *
     * @param transportationTask 实例对象
     * @return 实例对象
     */
    TransportationTask update(TransportationTask transportationTask);

    /**
     * 通过主键删除数据
     *
     * @param transportationTaskId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer transportationTaskId);

    /**
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
}
