package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.dto.CertificateDTO;
import com.cqu.kapok.kapoktpls.entity.Certificate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Certificate)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 12:07:05
 */
public interface CertificateService {

    /**
     * 通过ID查询单条数据
     *
     * @param certificateId 主键
     * @return 实例对象
     */
    Certificate queryById(Integer certificateId);

    /**
     * 分页查询
     *
     * @param certificate 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Certificate> queryByPage(Certificate certificate, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param certificate 实例对象
     * @return 实例对象
     */
    Certificate insert(Certificate certificate);

    /**
     * 修改数据
     *
     * @param certificate 实例对象
     * @return 实例对象
     */
    Certificate update(Certificate certificate);

    /**
     * 通过主键删除数据
     *
     * @param certificateId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer certificateId);
    List<Certificate> queryAll(CertificateDTO certificateDTO);

    Long getCertificateByConditionCount(Certificate certificate);
}
