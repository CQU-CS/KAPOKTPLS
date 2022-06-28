package com.cqu.kapok.kapoktpls.dao;

import com.cqu.kapok.kapoktpls.dto.CarrierManageDTO;
import com.cqu.kapok.kapoktpls.dto.CertificateDTO;
import com.cqu.kapok.kapoktpls.entity.CarrierManage;
import com.cqu.kapok.kapoktpls.entity.Certificate;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Certificate)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-28 12:07:05
 */
public interface CertificateDao {

    /**
     * 通过ID查询单条数据
     *
     * @param certificateId 主键
     * @return 实例对象
     */
    Certificate queryById(Integer certificateId);

    /**
     * 查询指定行数据
     *
     * @param certificate 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Certificate> queryAllByLimit(Certificate certificate, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param certificate 查询条件
     * @return 总行数
     */
    long count(Certificate certificate);

    /**
     * 新增数据
     *
     * @param certificate 实例对象
     * @return 影响行数
     */
    int insert(Certificate certificate);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Certificate> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Certificate> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Certificate> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Certificate> entities);

    /**
     * 修改数据
     *
     * @param certificate 实例对象
     * @return 影响行数
     */
    int update(Certificate certificate);

    /**
     * 通过主键删除数据
     *
     * @param certificateId 主键
     * @return 影响行数
     */
    int deleteById(Integer certificateId);
    List<Certificate> queryAll(CertificateDTO certificateDTO);

    Long getCertificateByConditionCount(Certificate certificate);
}

