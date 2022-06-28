package com.cqu.kapok.kapoktpls.dao;

import com.cqu.kapok.kapoktpls.dto.CompanyDTO;
import com.cqu.kapok.kapoktpls.dto.EcdDTO;
import com.cqu.kapok.kapoktpls.entity.Company;
import com.cqu.kapok.kapoktpls.entity.Ecd;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Ecd)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-28 14:49:10
 */
public interface EcdDao {

    /**
     * 通过ID查询单条数据
     *
     * @param ecdId 主键
     * @return 实例对象
     */
    Ecd queryById(Integer ecdId);

    /**
     * 查询指定行数据
     *
     * @param ecd 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Ecd> queryAllByLimit(Ecd ecd, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param ecd 查询条件
     * @return 总行数
     */
    long count(Ecd ecd);

    /**
     * 新增数据
     *
     * @param ecd 实例对象
     * @return 影响行数
     */
    int insert(Ecd ecd);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Ecd> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Ecd> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Ecd> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Ecd> entities);

    /**
     * 修改数据
     *
     * @param ecd 实例对象
     * @return 影响行数
     */
    int update(Ecd ecd);

    /**
     * 通过主键删除数据
     *
     * @param ecdId 主键
     * @return 影响行数
     */
    int deleteById(Integer ecdId);
    List<Ecd> queryAll(EcdDTO ecdDTO);

    Long getEcdByConditionCount(Ecd ecd);
}

