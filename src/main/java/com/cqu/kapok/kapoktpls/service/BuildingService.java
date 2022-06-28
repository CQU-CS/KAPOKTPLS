package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.entity.Building;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Building)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 08:56:47
 */
public interface BuildingService {

    /**
     * 通过ID查询单条数据
     *
     * @param buildingId 主键
     * @return 实例对象
     */
    Building queryById(Integer buildingId);

    /**
     * 分页查询
     *
     * @param building 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Building> queryByPage(Building building, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param building 实例对象
     * @return 实例对象
     */
    Building insert(Building building);

    /**
     * 修改数据
     *
     * @param building 实例对象
     * @return 实例对象
     */
    Building update(Building building);

    /**
     * 通过主键删除数据
     *
     * @param buildingId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer buildingId);

}
