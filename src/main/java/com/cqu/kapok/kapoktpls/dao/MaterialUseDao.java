package com.cqu.kapok.kapoktpls.dao;

import com.cqu.kapok.kapoktpls.entity.MaterialUse;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (MaterialUse)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-28 09:43:26
 */
public interface MaterialUseDao {

    /**
     * 通过ID查询单条数据
     *
     * @param materialUseId 主键
     * @return 实例对象
     */
    MaterialUse queryById(Integer materialUseId);

    /**
     * 查询指定行数据
     *
     * @param materialUse 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<MaterialUse> queryAllByLimit(MaterialUse materialUse, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param materialUse 查询条件
     * @return 总行数
     */
    long count(MaterialUse materialUse);

    /**
     * 新增数据
     *
     * @param materialUse 实例对象
     * @return 影响行数
     */
    int insert(MaterialUse materialUse);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MaterialUse> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MaterialUse> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MaterialUse> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MaterialUse> entities);

    /**
     * 修改数据
     *
     * @param materialUse 实例对象
     * @return 影响行数
     */
    int update(MaterialUse materialUse);

    /**
     * 通过主键删除数据
     *
     * @param materialUseId 主键
     * @return 影响行数
     */
    int deleteById(Integer materialUseId);

    /**
     * 条件查询
     * @param materialUse
     * @return
     */
    List<MaterialUse> getByCondition(MaterialUse materialUse);

}

