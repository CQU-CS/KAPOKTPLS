package com.cqu.kapok.kapoktpls.dao;

import com.cqu.kapok.kapoktpls.dto.GoodsPurchaseDTO;
import com.cqu.kapok.kapoktpls.dto.ProfitDTO;
import com.cqu.kapok.kapoktpls.entity.GoodsPurchase;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (GoodsPurchase)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-28 21:11:50
 */
public interface GoodsPurchaseDao {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsPurchaseId 主键
     * @return 实例对象
     */
    GoodsPurchase queryById(Integer goodsPurchaseId);

    /**
     * 查询指定行数据
     *
     * @param goodsPurchase 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<GoodsPurchase> queryAllByLimit(GoodsPurchase goodsPurchase, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param goodsPurchase 查询条件
     * @return 总行数
     */
    long count(GoodsPurchase goodsPurchase);

    /**
     * 新增数据
     *
     * @param goodsPurchase 实例对象
     * @return 影响行数
     */
    int insert(GoodsPurchase goodsPurchase);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<GoodsPurchase> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<GoodsPurchase> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<GoodsPurchase> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<GoodsPurchase> entities);

    /**
     * 修改数据
     *
     * @param goodsPurchase 实例对象
     * @return 影响行数
     */
    int update(GoodsPurchase goodsPurchase);

    /**
     * 通过主键删除数据
     *
     * @param goodsPurchaseId 主键
     * @return 影响行数
     */
    int deleteById(Integer goodsPurchaseId);

	List<GoodsPurchase> queryAll(GoodsPurchaseDTO goodsPurchaseDTO);

    Long getGoodsPurchaseByConditionCount(GoodsPurchase goodsPurchase);

    Long getGoodsPurchaseProfit(ProfitDTO profitDTO);
}

