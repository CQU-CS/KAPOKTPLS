package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.dto.TruckDTO;
import com.cqu.kapok.kapoktpls.entity.Truck;
import com.cqu.kapok.kapoktpls.dao.TruckDao;
import com.cqu.kapok.kapoktpls.service.TruckService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Truck)表服务实现类
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
@Service("truckService")
public class TruckServiceImpl implements TruckService {
    @Resource
    private TruckDao truckDao;

    /**
     * 通过ID查询单条数据
     *
     * @param truckId 主键
     * @return 实例对象
     */
    @Override
    public Truck queryById(Integer truckId) {
        return this.truckDao.queryById(truckId);
    }

    /**
     * 分页查询
     *
     * @param truck 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Truck> queryByPage(Truck truck, PageRequest pageRequest) {
        long total = this.truckDao.count(truck);
        return new PageImpl<>(this.truckDao.queryAllByLimit(truck, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param truck 实例对象
     * @return 实例对象
     */
    @Override
    public Truck insert(Truck truck) {
        this.truckDao.insert(truck);
        return truck;
    }

    /**
     * 修改数据
     *
     * @param truck 实例对象
     * @return 实例对象
     */
    @Override
    public Truck update(Truck truck) {
        this.truckDao.update(truck);
        return this.queryById(truck.getTruckId());
    }

    /**
     * 通过主键删除数据
     *
     * @param truckId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer truckId) {
        return this.truckDao.deleteById(truckId) > 0;
    }

    /**
     *
     * @param truck
     * @return
     */
    @Override
    public List<Truck> queryByTruck(Truck truck) {
        return this.truckDao.queryByTruck(truck);
    }

    /**
     *
     * @param truckDTO
     * @return
     */
    @Override
    public List<Truck> queryByTruckDTO(TruckDTO truckDTO) {
        return this.truckDao.queryByTruckDTO(truckDTO);
    }

    /**
     *
     * @param truck
     * @return
     */
    @Override
    public Long getTruckByConditionCount(Truck truck) {
        return this.truckDao.getTruckByConditionCount(truck);
    }
}
