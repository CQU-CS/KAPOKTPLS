package com.cqu.kapok.kapoktpls.dao;

import com.cqu.kapok.kapoktpls.dto.MaterialPurchaseDTO;
import com.cqu.kapok.kapoktpls.entity.MaterialPurchase;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (MaterialPurchase)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-28 21:19:57
 */
public interface MaterialPurchaseDao {

    /**
     * 通过ID查询单条数据
     *
     * @param materialPurchaseId 主键
     * @return 实例对象
     */
    MaterialPurchase queryById(Integer materialPurchaseId);

    /**
     * 查询指定行数据
     *
     * @param materialPurchase 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<MaterialPurchase> queryAllByLimit(MaterialPurchase materialPurchase, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param materialPurchase 查询条件
     * @return 总行数
     */
    long count(MaterialPurchase materialPurchase);

    /**
     * 新增数据
     *
     * @param materialPurchase 实例对象
     * @return 影响行数
     */
    int insert(MaterialPurchase materialPurchase);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MaterialPurchase> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MaterialPurchase> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MaterialPurchase> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MaterialPurchase> entities);

    /**
     * 修改数据
     *
     * @param materialPurchase 实例对象
     * @return 影响行数
     */
    int update(MaterialPurchase materialPurchase);

    /**
     * 通过主键删除数据
     *
     * @param materialPurchaseId 主键
     * @return 影响行数
     */
    int deleteById(Integer materialPurchaseId);

	List<MaterialPurchase> queryAll(MaterialPurchaseDTO materialPurchaseDTO);

    Long getMaterialPurchaseByConditionCount(MaterialPurchase materialPurchase);
}

