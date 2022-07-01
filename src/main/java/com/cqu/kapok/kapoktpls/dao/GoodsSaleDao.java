package com.cqu.kapok.kapoktpls.dao;

import com.cqu.kapok.kapoktpls.dto.GoodsSaleDTO;
import com.cqu.kapok.kapoktpls.dto.ProfitDTO;
import com.cqu.kapok.kapoktpls.entity.GoodsSale;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (GoodsSale)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-28 21:18:44
 */
public interface GoodsSaleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsSaleId 主键
     * @return 实例对象
     */
    GoodsSale queryById(Integer goodsSaleId);

    /**
     * 查询指定行数据
     *
     * @param goodsSale 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<GoodsSale> queryAllByLimit(GoodsSale goodsSale, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param goodsSale 查询条件
     * @return 总行数
     */
    long count(GoodsSale goodsSale);

    /**
     * 新增数据
     *
     * @param goodsSale 实例对象
     * @return 影响行数
     */
    int insert(GoodsSale goodsSale);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<GoodsSale> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<GoodsSale> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<GoodsSale> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<GoodsSale> entities);

    /**
     * 修改数据
     *
     * @param goodsSale 实例对象
     * @return 影响行数
     */
    int update(GoodsSale goodsSale);

    /**
     * 通过主键删除数据
     *
     * @param goodsSaleId 主键
     * @return 影响行数
     */
    int deleteById(Integer goodsSaleId);

	List<GoodsSale> queryAll(GoodsSaleDTO goodsSaleDTO);

    Long getGoodsSaleByConditionCount(GoodsSale goodsSale);

    Long getGoodsSaleProfit(ProfitDTO profitDTO);
}

