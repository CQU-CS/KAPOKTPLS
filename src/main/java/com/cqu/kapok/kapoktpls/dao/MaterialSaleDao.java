package com.cqu.kapok.kapoktpls.dao;

import com.cqu.kapok.kapoktpls.dto.ProfitDTO;
import com.cqu.kapok.kapoktpls.entity.MaterialSale;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

/**
 * (MaterialSale)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-28 09:40:15
 */
public interface MaterialSaleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param materialSaleId 主键
     * @return 实例对象
     */
    MaterialSale queryById(Integer materialSaleId);

    /**
     * 查询指定行数据
     *
     * @param materialSale 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<MaterialSale> queryAllByLimit(MaterialSale materialSale, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param materialSale 查询条件
     * @return 总行数
     */
    long count(MaterialSale materialSale);

    /**
     * 新增数据
     *
     * @param materialSale 实例对象
     * @return 影响行数
     */
    int insert(MaterialSale materialSale);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MaterialSale> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MaterialSale> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MaterialSale> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MaterialSale> entities);

    /**
     * 修改数据
     *
     * @param materialSale 实例对象
     * @return 影响行数
     */
    int update(MaterialSale materialSale);

    /**
     * 通过主键删除数据
     *
     * @param materialSaleId 主键
     * @return 影响行数
     */
    int deleteById(Integer materialSaleId);

    /**
     * 条件查询
     * @param materialSale
     * @return
     */
    List<MaterialSale> getByCondition(MaterialSale materialSale);
    Long getMaterialSaleProfit(ProfitDTO profitDTO);

    Long getMonthPrice(Date date);
}

