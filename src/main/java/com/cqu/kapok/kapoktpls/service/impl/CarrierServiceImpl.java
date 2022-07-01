package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.dao.CarrierDao;
import com.cqu.kapok.kapoktpls.dto.CarrierDTO;
import com.cqu.kapok.kapoktpls.entity.Carrier;
import com.cqu.kapok.kapoktpls.service.CarrierService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Carrier)表服务实现类
 *
 * @author makejava
 * @since 2022-06-28 09:05:49
 */
@Service("carrierService")
public class CarrierServiceImpl implements CarrierService {
    @Resource
    private CarrierDao carrierDao;

    /**
     * 通过ID查询单条数据
     *
     * @param carrierId 主键
     * @return 实例对象
     */
    @Override
    public Carrier queryById(Integer carrierId) {
        return this.carrierDao.queryById(carrierId);
    }

    /**
     * 分页查询
     *
     * @param carrier 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @Override
//    public Page<Carrier> queryByPage(Carrier carrier, PageRequest pageRequest) {
//        long total = this.carrierDao.count(carrier);
//        return new PageImpl<>(this.carrierDao.queryAllByLimit(carrier, pageRequest), pageRequest, total);
//    }

    /**
     * 新增数据
     *
     * @param carrier 实例对象
     * @return 实例对象
     */
    @Override
    public Carrier insert(Carrier carrier) {
        this.carrierDao.insert(carrier);
        return carrier;
    }

    /**
     * 修改数据
     *
     * @param carrier 实例对象
     * @return 实例对象
     */
    @Override
    public Carrier update(Carrier carrier) {
        this.carrierDao.update(carrier);
        return this.queryById(carrier.getCarrierId());
    }

    /**
     * 通过主键删除数据
     *
     * @param carrierId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer carrierId) {
        return this.carrierDao.deleteById(carrierId) > 0;
    }

    @Override
    public List<Carrier> queryAll(CarrierDTO carrierDTO) {
        return this.carrierDao.queryAll(carrierDTO);
    }

    @Override
    public Long getCarrierByConditionCount(Carrier carrier) {
        return this.carrierDao.getCarrierByConditionCount(carrier);
    }
    @Override
    public List<Carrier> queryByCarrier(Carrier carrier){
        return this.carrierDao.queryByCarrier(carrier);
    }
}
