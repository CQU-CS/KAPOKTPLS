package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.entity.RepairRecord;
import com.cqu.kapok.kapoktpls.dao.RepairRecordDao;
import com.cqu.kapok.kapoktpls.service.RepairRecordService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (RepairRecord)表服务实现类
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
@Service("repairRecordService")
public class RepairRecordServiceImpl implements RepairRecordService {
    @Resource
    private RepairRecordDao repairRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param repairRecordId 主键
     * @return 实例对象
     */
    @Override
    public RepairRecord queryById(Integer repairRecordId) {
        return this.repairRecordDao.queryById(repairRecordId);
    }


    /**
     * 分页查询
     *
     * @param repairRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<RepairRecord> queryByPage(RepairRecord repairRecord, PageRequest pageRequest) {
        long total = this.repairRecordDao.count(repairRecord);
        return new PageImpl<>(this.repairRecordDao.queryAllByLimit(repairRecord, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param repairRecord 实例对象
     * @return 实例对象
     */
    @Override
    public RepairRecord insert(RepairRecord repairRecord) {
        this.repairRecordDao.insert(repairRecord);
        return repairRecord;
    }

    /**
     * 修改数据
     *
     * @param repairRecord 实例对象
     * @return 实例对象
     */
    @Override
    public RepairRecord update(RepairRecord repairRecord) {
        this.repairRecordDao.update(repairRecord);
        return this.queryById(repairRecord.getRepairRecordId());
    }

    /**
     * 通过主键删除数据
     *
     * @param repairRecordId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer repairRecordId) {
        return this.repairRecordDao.deleteById(repairRecordId) > 0;
    }

    /**
     * 条件查询
     * @param repairRecord
     * @return
     */
    @Override
    public List<RepairRecord> getByCondition(RepairRecord repairRecord) {
        return this.repairRecordDao.getByCondition(repairRecord);
    }

    /**
     * 计数
     * @param repairRecord
     * @return
     */
    @Override
    public Long count(RepairRecord repairRecord) {
        return this.repairRecordDao.count(repairRecord);
    }
}
