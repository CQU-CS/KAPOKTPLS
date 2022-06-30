package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.CarrierManageDTO;
import com.cqu.kapok.kapoktpls.dto.CertificateDTO;
import com.cqu.kapok.kapoktpls.entity.*;
import com.cqu.kapok.kapoktpls.service.CertificateService;
import com.cqu.kapok.kapoktpls.service.PersonService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.utils.result.code.Code;
import com.cqu.kapok.kapoktpls.vo.CertificateVo;
import com.cqu.kapok.kapoktpls.vo.CompanyVo;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    @Resource
    private PersonService personService;
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
     * @param certificateVo 实体
     * @return 新增结果
     */
    @PostMapping("addByCertificate")
    public DataResult add(@RequestBody CertificateVo certificateVo) {
        Certificate certificate = new Certificate();
        Person person= new Person();
        BeanUtils.copyProperties(certificateVo, certificate);
        if(certificateVo.getPersonName()!=null) {
            person.setPersonName(certificateVo.getPersonName());
            List<Person> persons = this.personService.queryByPerson(person);
            if (persons.size() == 0) {
                person.setCompanyId(666);
                Person insert = this.personService.insert(person);
                certificate.setPersonId(insert.getPersonId());
            } else {
                for (Person person1:persons) {
                    certificate.setPersonId(person1.getPersonId());
                }
            }
        }
        return  DataResult.successByData(this.certificateService.insert(certificate));
    }

    /**
     * 编辑数据
     *
     * @param certificateVo 实体
     * @return 编辑结果
     */
    @PostMapping("editByCertificate")
    public  DataResult edit(@RequestBody CertificateVo certificateVo) {
        System.out.println("2898479842");
        System.out.println(certificateVo.getCertificateId());
        Certificate certificate = new Certificate();
        Person person= new Person();
        BeanUtils.copyProperties(certificateVo, certificate);
        if(certificateVo.getPersonName()!=null) {
            person.setPersonName(certificateVo.getPersonName());
            List<Person> persons = this.personService.queryByPerson(person);
            if (persons.size() == 0) {
                person.setCompanyId(666);
                Person insert = this.personService.insert(person);
                certificate.setPersonId(insert.getPersonId());
            } else {
                for (Person person1:persons) {
                    certificate.setPersonId(person1.getPersonId());
                }
            }
        }

        return  DataResult.successByData(this.certificateService.update(certificate));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteByCertificateId")
    public DataResult deleteById(Integer id) {
        boolean b = this.certificateService.deleteById(id);
        return DataResult.errByErrCode(Code.SUCCESS);
    }
    /**
     * 通过CertificateDTO分页查询
     * @param certificateDTO
     * @return 查询结果列表和查询总数
     */
    @PostMapping("queryByCertificate")
    DataResult queryByCertificate(@RequestBody CertificateDTO certificateDTO){
        ArrayList<CertificateVo> certificateVos = new ArrayList<>();
        certificateDTO.setPage((certificateDTO.getPage() - 1) * certificateDTO.getLimit());
        List<Certificate> certificates =this.certificateService.queryAll(certificateDTO);
        Certificate certificate = new Certificate();
        BeanUtils.copyProperties(certificateDTO,certificate);
        Long total = this.certificateService.getCertificateByConditionCount(certificate);
        for(Certificate certificate1:certificates){
            //查询人的名字
            String personName = this.personService.queryById(certificate1.getPersonId()).getPersonName();
            CertificateVo certificateVo = new CertificateVo();
            BeanUtils.copyProperties(certificate1,certificateVo);
            certificateVo.setPersonName(personName);
            certificateVos.add(certificateVo);
        }
        return DataResult.successByTotalData(certificateVos, total);
    }
}

