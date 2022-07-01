package com.cqu.kapok.kapoktpls.dao;

import com.cqu.kapok.kapoktpls.dto.TruckPurchaseDTO;
import com.cqu.kapok.kapoktpls.entity.TruckPurchase;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

/**
 * (TruckPurchase)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
public interface TruckPurchaseDao {

    /**
     * 通过ID查询单条数据
     *
     * @param truckPurchaseId 主键
     * @return 实例对象
     */
    TruckPurchase queryById(Integer truckPurchaseId);

    /**
     * 查询指定行数据
     *
     * @param truckPurchase 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TruckPurchase> queryAllByLimit(TruckPurchase truckPurchase, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param truckPurchase 查询条件
     * @return 总行数
     */
    long count(TruckPurchase truckPurchase);

    /**
     * 新增数据
     *
     * @param truckPurchase 实例对象
     * @return 影响行数
     */
    int insert(TruckPurchase truckPurchase);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TruckPurchase> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TruckPurchase> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TruckPurchase> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TruckPurchase> entities);

    /**
     * 修改数据
     *
     * @param truckPurchase 实例对象
     * @return 影响行数
     */
    int update(TruckPurchase truckPurchase);

    /**
     * 通过主键删除数据
     *
     * @param truckPurchaseId 主键
     * @return 影响行数
     */
    int deleteById(Integer truckPurchaseId);

    /**
     *
     * @param truckPurchase
     * @return
     */
    List<TruckPurchase> queryByTruckPurchase(TruckPurchase truckPurchase);

    /**
     *
     * @param truckPurchaseDTO
     * @return
     */
    List<TruckPurchase> queryByTruckPurchaseDTO(TruckPurchaseDTO truckPurchaseDTO);

    /**
     *
     * @param truckPurchase
     * @return
     */
    Long getTruckPurchaseByConditionCount(TruckPurchase truckPurchase);

    Long getMonthCost(Date date);
}

