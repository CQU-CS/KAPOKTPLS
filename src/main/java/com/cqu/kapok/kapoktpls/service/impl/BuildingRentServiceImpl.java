package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.entity.BuildingRent;
import com.cqu.kapok.kapoktpls.dao.BuildingRentDao;
import com.cqu.kapok.kapoktpls.service.BuildingRentService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (BuildingRent)表服务实现类
 *
 * @author makejava
 * @since 2022-06-28 08:57:05
 */
@Service("buildingRentService")
public class BuildingRentServiceImpl implements BuildingRentService {
    @Resource
    private BuildingRentDao buildingRentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param buildingRentId 主键
     * @return 实例对象
     */
    @Override
    public BuildingRent queryById(Integer buildingRentId) {
        return this.buildingRentDao.queryById(buildingRentId);
    }

    /**
     * 分页查询
     *
     * @param buildingRent 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<BuildingRent> queryByPage(BuildingRent buildingRent, PageRequest pageRequest) {
        long total = this.buildingRentDao.count(buildingRent);
        return new PageImpl<>(this.buildingRentDao.queryAllByLimit(buildingRent, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param buildingRent 实例对象
     * @return 实例对象
     */
    @Override
    public BuildingRent insert(BuildingRent buildingRent) {
        this.buildingRentDao.insert(buildingRent);
        return buildingRent;
    }

    /**
     * 修改数据
     *
     * @param buildingRent 实例对象
     * @return 实例对象
     */
    @Override
    public BuildingRent update(BuildingRent buildingRent) {
        this.buildingRentDao.update(buildingRent);
        return this.queryById(buildingRent.getBuildingRentId());
    }

    /**
     * 通过主键删除数据
     *
     * @param buildingRentId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer buildingRentId) {
        return this.buildingRentDao.deleteById(buildingRentId) > 0;
    }
}
