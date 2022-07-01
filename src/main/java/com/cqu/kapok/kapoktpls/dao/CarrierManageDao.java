package com.cqu.kapok.kapoktpls.dao;

import com.cqu.kapok.kapoktpls.dto.CarrierDTO;
import com.cqu.kapok.kapoktpls.dto.CarrierManageDTO;
import com.cqu.kapok.kapoktpls.entity.Carrier;
import com.cqu.kapok.kapoktpls.entity.CarrierManage;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

/**
 * (CarrierManage)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-28 10:46:00
 */
public interface CarrierManageDao {

    /**
     * 通过ID查询单条数据
     *
     * @param carrierManageId 主键
     * @return 实例对象
     */
    CarrierManage queryById(Integer carrierManageId);

    /**
     * 查询指定行数据
     *
     * @param carrierManage 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<CarrierManage> queryAllByLimit(CarrierManage carrierManage, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param carrierManage 查询条件
     * @return 总行数
     */
    long count(CarrierManage carrierManage);

    /**
     * 新增数据
     *
     * @param carrierManage 实例对象
     * @return 影响行数
     */
    int insert(CarrierManage carrierManage);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CarrierManage> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CarrierManage> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CarrierManage> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<CarrierManage> entities);

    /**
     * 修改数据
     *
     * @param carrierManage 实例对象
     * @return 影响行数
     */
    int update(CarrierManage carrierManage);

    /**
     * 通过主键删除数据
     *
     * @param carrierManageId 主键
     * @return 影响行数
     */
    int deleteById(Integer carrierManageId);

    List<CarrierManage> queryAll(CarrierManageDTO carrierManageDTO);

    Long getCarrierMangeByConditionCount(CarrierManage carrierManage);

    Long getMonthPrice(Date date);
}

