package com.cqu.kapok.kapoktpls.dao;

import com.cqu.kapok.kapoktpls.entity.Truck;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Truck)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
public interface TruckDao {

    /**
     * 通过ID查询单条数据
     *
     * @param truckId 主键
     * @return 实例对象
     */
    Truck queryById(Integer truckId);

    /**
     * 查询指定行数据
     *
     * @param truck 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Truck> queryAllByLimit(Truck truck, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param truck 查询条件
     * @return 总行数
     */
    long count(Truck truck);

    /**
     * 新增数据
     *
     * @param truck 实例对象
     * @return 影响行数
     */
    int insert(Truck truck);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Truck> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Truck> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Truck> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Truck> entities);

    /**
     * 修改数据
     *
     * @param truck 实例对象
     * @return 影响行数
     */
    int update(Truck truck);

    /**
     * 通过主键删除数据
     *
     * @param truckId 主键
     * @return 影响行数
     */
    int deleteById(Integer truckId);

    DataResult<List<Truck>> queryByTruck(Truck truck);
}

