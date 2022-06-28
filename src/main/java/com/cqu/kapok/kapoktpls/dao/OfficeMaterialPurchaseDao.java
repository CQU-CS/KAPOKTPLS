package com.cqu.kapok.kapoktpls.dao;

import com.cqu.kapok.kapoktpls.entity.OfficeMaterialPurchase;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (OfficeMaterialPurchase)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-28 09:44:07
 */
public interface OfficeMaterialPurchaseDao {

    /**
     * 通过ID查询单条数据
     *
     * @param officeMaterialPurchaseId 主键
     * @return 实例对象
     */
    OfficeMaterialPurchase queryById(Integer officeMaterialPurchaseId);

    /**
     * 查询指定行数据
     *
     * @param officeMaterialPurchase 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<OfficeMaterialPurchase> queryAllByLimit(OfficeMaterialPurchase officeMaterialPurchase, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param officeMaterialPurchase 查询条件
     * @return 总行数
     */
    long count(OfficeMaterialPurchase officeMaterialPurchase);

    /**
     * 新增数据
     *
     * @param officeMaterialPurchase 实例对象
     * @return 影响行数
     */
    int insert(OfficeMaterialPurchase officeMaterialPurchase);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<OfficeMaterialPurchase> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<OfficeMaterialPurchase> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<OfficeMaterialPurchase> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<OfficeMaterialPurchase> entities);

    /**
     * 修改数据
     *
     * @param officeMaterialPurchase 实例对象
     * @return 影响行数
     */
    int update(OfficeMaterialPurchase officeMaterialPurchase);

    /**
     * 通过主键删除数据
     *
     * @param officeMaterialPurchaseId 主键
     * @return 影响行数
     */
    int deleteById(Integer officeMaterialPurchaseId);

    /**
     * 条件查询
     * @param officeMaterialPurchase
     * @return
     */
    List<OfficeMaterialPurchase> getByCondition(OfficeMaterialPurchase officeMaterialPurchase);

}

