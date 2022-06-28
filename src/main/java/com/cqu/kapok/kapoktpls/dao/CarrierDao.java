package com.cqu.kapok.kapoktpls.dao;

import com.cqu.kapok.kapoktpls.dto.CarrierDTO;
import com.cqu.kapok.kapoktpls.entity.Carrier;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Carrier)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-28 09:05:49
 */
public interface CarrierDao {

    /**
     * 通过ID查询单条数据
     *
     * @param carrierId 主键
     * @return 实例对象
     */
    Carrier queryById(Integer carrierId);

    /**
     * 查询指定行数据
     *
     * @param carrier 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Carrier> queryAllByLimit(Carrier carrier, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param carrier 查询条件
     * @return 总行数
     */
    long count(Carrier carrier);

    /**
     * 新增数据
     *
     * @param carrier 实例对象
     * @return 影响行数
     */
    int insert(Carrier carrier);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Carrier> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Carrier> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Carrier> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Carrier> entities);

    /**
     * 修改数据
     *
     * @param carrier 实例对象
     * @return 影响行数
     */
    int update(Carrier carrier);

    /**
     * 通过主键删除数据
     *
     * @param carrierId 主键
     * @return 影响行数
     */
    int deleteById(Integer carrierId);

    List<Carrier> queryAll(CarrierDTO carrierDTO);

    Long getCarrierByConditionCount(Carrier carrier);

}

