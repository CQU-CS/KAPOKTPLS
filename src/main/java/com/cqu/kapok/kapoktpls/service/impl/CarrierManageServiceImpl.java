package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.dto.CarrierDTO;
import com.cqu.kapok.kapoktpls.dto.CarrierManageDTO;
import com.cqu.kapok.kapoktpls.entity.Carrier;
import com.cqu.kapok.kapoktpls.entity.CarrierManage;
import com.cqu.kapok.kapoktpls.dao.CarrierManageDao;
import com.cqu.kapok.kapoktpls.service.CarrierManageService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CarrierManage)表服务实现类
 *
 * @author makejava
 * @since 2022-06-28 10:46:14
 */
@Service("carrierManageService")
public class CarrierManageServiceImpl implements CarrierManageService {
    @Resource
    private CarrierManageDao carrierManageDao;

    /**
     * 通过ID查询单条数据
     *
     * @param carrierManageId 主键
     * @return 实例对象
     */
    @Override
    public CarrierManage queryById(Integer carrierManageId) {
        return this.carrierManageDao.queryById(carrierManageId);
    }

    /**
     * 分页查询
     *
     * @param carrierManage 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<CarrierManage> queryByPage(CarrierManage carrierManage, PageRequest pageRequest) {
        long total = this.carrierManageDao.count(carrierManage);
        return new PageImpl<>(this.carrierManageDao.queryAllByLimit(carrierManage, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param carrierManage 实例对象
     * @return 实例对象
     */
    @Override
    public CarrierManage insert(CarrierManage carrierManage) {
        this.carrierManageDao.insert(carrierManage);
        return carrierManage;
    }

    /**
     * 修改数据
     *
     * @param carrierManage 实例对象
     * @return 实例对象
     */
    @Override
    public CarrierManage update(CarrierManage carrierManage) {
        this.carrierManageDao.update(carrierManage);
        return this.queryById(carrierManage.getCarrierManageId());
    }

    /**
     * 通过主键删除数据
     *
     * @param carrierManageId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer carrierManageId) {
        return this.carrierManageDao.deleteById(carrierManageId) > 0;
    }

    @Override
    public List<CarrierManage> queryAll(CarrierManageDTO carrierManageDTO) {
        return this.carrierManageDao.queryAll(carrierManageDTO);
    }

    @Override
    public Long getCarrierMangeByConditionCount(CarrierManage carrierManage) {
        return this.carrierManageDao.getCarrierMangeByConditionCount(carrierManage);
    }
}
