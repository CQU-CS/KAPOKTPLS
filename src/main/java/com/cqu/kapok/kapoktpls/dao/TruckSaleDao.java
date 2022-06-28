package com.cqu.kapok.kapoktpls.dao;

import com.cqu.kapok.kapoktpls.entity.TruckSale;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TruckSale)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
public interface TruckSaleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param truckSaleId 主键
     * @return 实例对象
     */
    TruckSale queryById(Integer truckSaleId);

    /**
     * 查询指定行数据
     *
     * @param truckSale 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TruckSale> queryAllByLimit(TruckSale truckSale, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param truckSale 查询条件
     * @return 总行数
     */
    long count(TruckSale truckSale);

    /**
     * 新增数据
     *
     * @param truckSale 实例对象
     * @return 影响行数
     */
    int insert(TruckSale truckSale);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TruckSale> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TruckSale> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TruckSale> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TruckSale> entities);

    /**
     * 修改数据
     *
     * @param truckSale 实例对象
     * @return 影响行数
     */
    int update(TruckSale truckSale);

    /**
     * 通过主键删除数据
     *
     * @param truckSaleId 主键
     * @return 影响行数
     */
    int deleteById(Integer truckSaleId);

    /**
     *
     * @param truckSale
     * @return
     */
    DataResult<List<TruckSale>> queryByTruckSale(TruckSale truckSale);
}

