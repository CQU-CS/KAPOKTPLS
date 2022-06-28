package com.cqu.kapok.kapoktpls.dao;

import com.cqu.kapok.kapoktpls.entity.Building;
import com.cqu.kapok.kapoktpls.entity.BuildingRent;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (BuildingRent)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-28 08:57:05
 */
public interface BuildingRentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param buildingRentId 主键
     * @return 实例对象
     */
    BuildingRent queryById(Integer buildingRentId);

    /**
     * 查询指定行数据
     *
     * @param buildingRent 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<BuildingRent> queryAllByLimit(BuildingRent buildingRent, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param buildingRent 查询条件
     * @return 总行数
     */
    long count(BuildingRent buildingRent);

    /**
     * 新增数据
     *
     * @param buildingRent 实例对象
     * @return 影响行数
     */
    int insert(BuildingRent buildingRent);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BuildingRent> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BuildingRent> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BuildingRent> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BuildingRent> entities);

    /**
     * 修改数据
     *
     * @param buildingRent 实例对象
     * @return 影响行数
     */
    int update(BuildingRent buildingRent);

    /**
     * 通过主键删除数据
     *
     * @param buildingRentId 主键
     * @return 影响行数
     */
    int deleteById(Integer buildingRentId);

    /**
     * 根据实体类查询
     * @param buildingRent
     * @return
     */
    DataResult<List<BuildingRent>> queryByBuildingRent(BuildingRent buildingRent);
}

