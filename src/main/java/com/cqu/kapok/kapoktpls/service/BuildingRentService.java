package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.entity.BuildingRent;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (BuildingRent)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 08:57:05
 */
public interface BuildingRentService {

    /**
     * 通过ID查询单条数据
     *
     * @param buildingRentId 主键
     * @return 实例对象
     */
    BuildingRent queryById(Integer buildingRentId);

    /**
     * 分页查询
     *
     * @param buildingRent 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<BuildingRent> queryByPage(BuildingRent buildingRent, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param buildingRent 实例对象
     * @return 实例对象
     */
    BuildingRent insert(BuildingRent buildingRent);

    /**
     * 修改数据
     *
     * @param buildingRent 实例对象
     * @return 实例对象
     */
    BuildingRent update(BuildingRent buildingRent);

    /**
     * 通过主键删除数据
     *
     * @param buildingRentId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer buildingRentId);

    /**
     * 根据实体类查询
     * @param buildingRent
     * @return
     */
    List<BuildingRent> queryByBuildingRent(BuildingRent buildingRent);
}
