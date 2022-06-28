package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.CarrierManageDTO;
import com.cqu.kapok.kapoktpls.dto.CertificateDTO;
import com.cqu.kapok.kapoktpls.entity.CarrierManage;
import com.cqu.kapok.kapoktpls.entity.Certificate;
import com.cqu.kapok.kapoktpls.service.CertificateService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Certificate)表控制层
 *
 * @author makejava
 * @since 2022-06-28 12:07:05
 */
@RestController
@RequestMapping("certificate")
public class CertificateController {
    /**
     * 服务对象
     */
    @Resource
    private CertificateService certificateService;

    /**
     * 分页查询
     *
     * @param certificate 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Certificate>> queryByPage(Certificate certificate, PageRequest pageRequest) {
        return ResponseEntity.ok(this.certificateService.queryByPage(certificate, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Certificate> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.certificateService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param certificate 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Certificate> add(Certificate certificate) {
        return ResponseEntity.ok(this.certificateService.insert(certificate));
    }

    /**
     * 编辑数据
     *
     * @param certificate 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Certificate> edit(Certificate certificate) {
        return ResponseEntity.ok(this.certificateService.update(certificate));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.certificateService.deleteById(id));
    }
    /**
     * 通过CertificateDTO分页查询
     * @param certificateDTO
     * @return 查询结果列表和查询总数
     */
    @PostMapping("queryByCertificate")
    DataResult queryByCertificate(@RequestBody CertificateDTO certificateDTO){
        certificateDTO.setPage((certificateDTO.getPage() - 1) * certificateDTO.getLimit());
        List<Certificate> certificates =this.certificateService.queryAll(certificateDTO);
        Certificate certificate = new Certificate();
        BeanUtils.copyProperties(certificateDTO,certificate);
        Long total = this.certificateService.getCertificateByConditionCount(certificate);
        return DataResult.successByTotalData(certificates, total);
    }
}

