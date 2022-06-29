package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.dto.BuildingDTO;
import com.cqu.kapok.kapoktpls.entity.Building;
import com.cqu.kapok.kapoktpls.dao.BuildingDao;
import com.cqu.kapok.kapoktpls.service.BuildingService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Building)表服务实现类
 *
 * @author makejava
 * @since 2022-06-28 08:56:47
 */
@Service("buildingService")
public class BuildingServiceImpl implements BuildingService {
    @Resource
    private BuildingDao buildingDao;

    /**
     * 通过ID查询单条数据
     *
     * @param buildingId 主键
     * @return 实例对象
     */
    @Override
    public Building queryById(Integer buildingId) {
        return this.buildingDao.queryById(buildingId);
    }

    /**
     * 分页查询
     *
     * @param building 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Building> queryByPage(Building building, PageRequest pageRequest) {
        long total = this.buildingDao.count(building);
        return new PageImpl<>(this.buildingDao.queryAllByLimit(building, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param building 实例对象
     * @return 实例对象
     */
    @Override
    public Building insert(Building building) {
        this.buildingDao.insert(building);
        return building;
    }

    /**
     * 修改数据
     *
     * @param building 实例对象
     * @return 实例对象
     */
    @Override
    public Building update(Building building) {
        this.buildingDao.update(building);
        return this.queryById(building.getBuildingId());
    }

    /**
     * 通过主键删除数据
     *
     * @param buildingId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer buildingId) {
        return this.buildingDao.deleteById(buildingId) > 0;
    }


    /**
     * 根据实体类查询
     * @param building
     * @return
     */
    @Override
    public List<Building> queryByBuilding(Building building) {
        return this.buildingDao.queryByBuilding(building);
    }

    /**
     * 分页查询
     * @param buildingDTO
     * @return
     */
    @Override
    public List<Building> queryByBuildingDTO(BuildingDTO buildingDTO) {
        return this.buildingDao.queryByBuildingDTO(buildingDTO);
    }

    @Override
    public Long getBuildingByConditionCount(Building building) {
        return this.buildingDao.getBuildingByConditionCount(building);
    }
}
