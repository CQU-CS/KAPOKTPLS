package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.entity.TruckRepairRecord;
import com.cqu.kapok.kapoktpls.dao.TruckRepairRecordDao;
import com.cqu.kapok.kapoktpls.service.TruckRepairRecordService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TruckRepairRecord)表服务实现类
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
@Service("truckRepairRecordService")
public class TruckRepairRecordServiceImpl implements TruckRepairRecordService {
    @Resource
    private TruckRepairRecordDao truckRepairRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param truckRepairRecordId 主键
     * @return 实例对象
     */
    @Override
    public TruckRepairRecord queryById(Integer truckRepairRecordId) {
        return this.truckRepairRecordDao.queryById(truckRepairRecordId);
    }

    /**
     * 分页查询
     *
     * @param truckRepairRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TruckRepairRecord> queryByPage(TruckRepairRecord truckRepairRecord, PageRequest pageRequest) {
        long total = this.truckRepairRecordDao.count(truckRepairRecord);
        return new PageImpl<>(this.truckRepairRecordDao.queryAllByLimit(truckRepairRecord, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param truckRepairRecord 实例对象
     * @return 实例对象
     */
    @Override
    public TruckRepairRecord insert(TruckRepairRecord truckRepairRecord) {
        this.truckRepairRecordDao.insert(truckRepairRecord);
        return truckRepairRecord;
    }

    /**
     * 修改数据
     *
     * @param truckRepairRecord 实例对象
     * @return 实例对象
     */
    @Override
    public TruckRepairRecord update(TruckRepairRecord truckRepairRecord) {
        this.truckRepairRecordDao.update(truckRepairRecord);
        return this.queryById(truckRepairRecord.getTruckRepairRecordId());
    }

    /**
     * 通过主键删除数据
     *
     * @param truckRepairRecordId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer truckRepairRecordId) {
        return this.truckRepairRecordDao.deleteById(truckRepairRecordId) > 0;
    }

    /**
     *
     * @param truckRepairRecord
     * @return
     */
    @Override
    public DataResult<List<TruckRepairRecord>> queryByTruckRepairRecord(TruckRepairRecord truckRepairRecord) {
        return this.truckRepairRecordDao.queryByTruckRepairRecord(truckRepairRecord);
    }
}
