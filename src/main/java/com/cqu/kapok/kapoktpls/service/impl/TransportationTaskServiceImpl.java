package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.dto.ProfitDTO;
import com.cqu.kapok.kapoktpls.dto.TransportationTaskDTO;
import com.cqu.kapok.kapoktpls.entity.TransportationTask;
import com.cqu.kapok.kapoktpls.dao.TransportationTaskDao;
import com.cqu.kapok.kapoktpls.service.TransportationTaskService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (TransportationTask)表服务实现类
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
@Service("transportationTaskService")
public class TransportationTaskServiceImpl implements TransportationTaskService {
    @Resource
    private TransportationTaskDao transportationTaskDao;

    /**
     * 通过ID查询单条数据
     *
     * @param transportationTaskId 主键
     * @return 实例对象
     */
    @Override
    public TransportationTask queryById(Integer transportationTaskId) {
        return this.transportationTaskDao.queryById(transportationTaskId);
    }

    /**
     * 分页查询
     *
     * @param transportationTask 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TransportationTask> queryByPage(TransportationTask transportationTask, PageRequest pageRequest) {
        long total = this.transportationTaskDao.count(transportationTask);
        return new PageImpl<>(this.transportationTaskDao.queryAllByLimit(transportationTask, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param transportationTask 实例对象
     * @return 实例对象
     */
    @Override
    public TransportationTask insert(TransportationTask transportationTask) {
        this.transportationTaskDao.insert(transportationTask);
        return transportationTask;
    }

    /**
     * 修改数据
     *
     * @param transportationTask 实例对象
     * @return 实例对象
     */
    @Override
    public TransportationTask update(TransportationTask transportationTask) {
        this.transportationTaskDao.update(transportationTask);
        return this.queryById(transportationTask.getTransportationTaskId());
    }

    /**
     * 通过主键删除数据
     *
     * @param transportationTaskId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer transportationTaskId) {
        return this.transportationTaskDao.deleteById(transportationTaskId) > 0;
    }

    @Override
    public List<TransportationTask> queryByTransportationTask(TransportationTask transportationTask) {
        return this.transportationTaskDao.queryByTransportationTask(transportationTask);
    }

    /**
     *
     * @param transportationTaskDTO
     * @return
     */
    @Override
    public List<TransportationTask> queryByTransportationTaskDTO(TransportationTaskDTO transportationTaskDTO) {
        return this.transportationTaskDao.queryByTransportationTaskDTO(transportationTaskDTO);
    }

    /**
     *
     * @param transportationTask
     * @return
     */
    @Override
    public Long getTransportationTaskByConditionCount(TransportationTask transportationTask) {
        return this.transportationTaskDao.getTransportationTaskByConditionCount(transportationTask);
    }
    @Override
    public Long getMonthProfit(ProfitDTO profitDTO){
        return this.transportationTaskDao.getMonthProfit(profitDTO);
    }

    @Override
    public Long getProfit(Date date) {
        return this.transportationTaskDao.getProfit(date);
    }
}
