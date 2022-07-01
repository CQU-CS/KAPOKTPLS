package com.cqu.kapok.kapoktpls.dao;

import com.cqu.kapok.kapoktpls.dto.BuildingSaleDTO;
import com.cqu.kapok.kapoktpls.entity.BuildingSale;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

/**
 * (BuildingSale)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-28 08:57:16
 */
public interface BuildingSaleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param buildingSaleId 主键
     * @return 实例对象
     */
    BuildingSale queryById(Integer buildingSaleId);

    /**
     * 查询指定行数据
     *
     * @param buildingSale 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<BuildingSale> queryAllByLimit(BuildingSale buildingSale, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param buildingSale 查询条件
     * @return 总行数
     */
    long count(BuildingSale buildingSale);

    /**
     * 新增数据
     *
     * @param buildingSale 实例对象
     * @return 影响行数
     */
    int insert(BuildingSale buildingSale);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BuildingSale> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BuildingSale> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BuildingSale> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BuildingSale> entities);

    /**
     * 修改数据
     *
     * @param buildingSale 实例对象
     * @return 影响行数
     */
    int update(BuildingSale buildingSale);

    /**
     * 通过主键删除数据
     *
     * @param buildingSaleId 主键
     * @return 影响行数
     */
    int deleteById(Integer buildingSaleId);

    /**
     * 根据实体类查询
     * @param buildingSale
     * @return
     */
    List<BuildingSale> queryByBuildingSale(BuildingSale buildingSale);

    /**
     * 分页查询
     * @param buildingSaleDTO
     * @return
     */
    List<BuildingSale> queryByBuildingSaleDTO(BuildingSaleDTO buildingSaleDTO);

    Long getBuildingSaleByConditionCount(BuildingSale buildingSale);

    Long getMonthPrice(Date date);
}

