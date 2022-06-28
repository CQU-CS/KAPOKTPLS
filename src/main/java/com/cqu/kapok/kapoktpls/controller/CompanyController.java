package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.CarrierDTO;
import com.cqu.kapok.kapoktpls.dto.CompanyDTO;
import com.cqu.kapok.kapoktpls.entity.Carrier;
import com.cqu.kapok.kapoktpls.entity.Company;
import com.cqu.kapok.kapoktpls.service.CompanyService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Company)表控制层
 *
 * @author makejava
 * @since 2022-06-25 10:03:24
 */
@RestController
@RequestMapping("company")
public class CompanyController {
    /**
     * 服务对象
     */
    @Resource
    private CompanyService companyService;

    /**
     * 分页查询
     *
     * @param company 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Company>> queryByPage(Company company, PageRequest pageRequest) {
        return ResponseEntity.ok(this.companyService.queryByPage(company, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Company> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.companyService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param company 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Company> add(Company company) {
        return ResponseEntity.ok(this.companyService.insert(company));
    }

    /**
     * 编辑数据
     *
     * @param company 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Company> edit(Company company) {
        return ResponseEntity.ok(this.companyService.update(company));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.companyService.deleteById(id));
    }
    /**
     * 通过CompanyDTO分页查询
     * @param companyDTO
     * @return
     */
    @PostMapping("queryByCompany")
    DataResult queryByCompany(@RequestBody CompanyDTO companyDTO){
        companyDTO.setPage((companyDTO.getPage() - 1) * companyDTO.getLimit());
        List<Company> companies =this.companyService.queryAll(companyDTO);
        Company company = new Company();
        BeanUtils.copyProperties(companyDTO,company);
        Long total = this.companyService.getCompanyByConditionCount(company);
        return DataResult.successByTotalData(companies, total);
    }
}

