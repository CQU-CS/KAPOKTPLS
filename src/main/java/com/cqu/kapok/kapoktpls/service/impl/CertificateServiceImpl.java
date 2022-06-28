package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.dto.CarrierDTO;
import com.cqu.kapok.kapoktpls.dto.CertificateDTO;
import com.cqu.kapok.kapoktpls.entity.Carrier;
import com.cqu.kapok.kapoktpls.entity.Certificate;
import com.cqu.kapok.kapoktpls.dao.CertificateDao;
import com.cqu.kapok.kapoktpls.service.CertificateService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Certificate)表服务实现类
 *
 * @author makejava
 * @since 2022-06-28 12:07:05
 */
@Service("certificateService")
public class CertificateServiceImpl implements CertificateService {
    @Resource
    private CertificateDao certificateDao;

    /**
     * 通过ID查询单条数据
     *
     * @param certificateId 主键
     * @return 实例对象
     */
    @Override
    public Certificate queryById(Integer certificateId) {
        return this.certificateDao.queryById(certificateId);
    }

    /**
     * 分页查询
     *
     * @param certificate 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Certificate> queryByPage(Certificate certificate, PageRequest pageRequest) {
        long total = this.certificateDao.count(certificate);
        return new PageImpl<>(this.certificateDao.queryAllByLimit(certificate, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param certificate 实例对象
     * @return 实例对象
     */
    @Override
    public Certificate insert(Certificate certificate) {
        this.certificateDao.insert(certificate);
        return certificate;
    }

    /**
     * 修改数据
     *
     * @param certificate 实例对象
     * @return 实例对象
     */
    @Override
    public Certificate update(Certificate certificate) {
        this.certificateDao.update(certificate);
        return this.queryById(certificate.getCertificateId());
    }

    /**
     * 通过主键删除数据
     *
     * @param certificateId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer certificateId) {
        return this.certificateDao.deleteById(certificateId) > 0;
    }
    @Override
    public List<Certificate> queryAll(CertificateDTO certificateDTO) {
        return this.certificateDao.queryAll(certificateDTO);
    }

    @Override
    public Long getCertificateByConditionCount(Certificate certificate) {
        return this.certificateDao.getCertificateByConditionCount(certificate);
    }
}
