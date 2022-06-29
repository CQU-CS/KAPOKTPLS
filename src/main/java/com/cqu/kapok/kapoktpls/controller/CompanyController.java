package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.CarrierDTO;
import com.cqu.kapok.kapoktpls.dto.CompanyDTO;
import com.cqu.kapok.kapoktpls.entity.Address;
import com.cqu.kapok.kapoktpls.entity.Carrier;
import com.cqu.kapok.kapoktpls.entity.Company;
import com.cqu.kapok.kapoktpls.service.AddressService;
import com.cqu.kapok.kapoktpls.service.CompanyService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.utils.result.code.Code;
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
    @Resource
    private AddressService addressService;

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
     * @param companyVo 实体
     * @return 新增结果
     */
    @PostMapping("addByCompany")
    public DataResult add(CompanyVo companyVo) {
        Company company = new Company();
        Address address = new Address();
        BeanUtils.copyProperties(companyVo, company);
        if(companyVo.getAddressContent()!=null){
            address.setAddressContent(companyVo.getAddressContent());
            List<Address> addresses = this.addressService.queryByAddress(address);
            if(addresses.size()==0){
                return DataResult.errByErrCode(Code.ADDRESS_NOT_EXIST);
            }
            for (Address address1 : addresses) {
                company.setAddressId(address1.getAddressId());
            }
        }
        return  DataResult.successByData(this.companyService.insert(company));
    }

    /**
     * 编辑数据
     *
     * @param companyVo 实体
     * @return 编辑结果
     */
    @PostMapping("editByCompany")
    public DataResult edit(CompanyVo companyVo) {
        Company company = new Company();
        Address address = new Address();
        BeanUtils.copyProperties(companyVo, company);
        if(companyVo.getAddressContent()!=null){
            address.setAddressContent(companyVo.getAddressContent());
            List<Address> addresses = this.addressService.queryByAddress(address);
            if(addresses.size()==0){
                return DataResult.errByErrCode(Code.ADDRESS_NOT_EXIST);
            }
            for (Address address1 : addresses) {
                company.setAddressId(address1.getAddressId());
            }
        }
        return DataResult.successByData(this.companyService.update(company));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteByCompanyId")
    public DataResult deleteById(Integer id) {
        System.out.println("id:"+id);
        if(this.companyService.deleteById(id)){
            return DataResult.succ();
        }else{
            return DataResult.errByErrCode(20001);
        }

    }
    /**
     * 通过CompanyDTO分页查询
     * @param companyDTO
     * @return 查询结果列表和查询总数
     */
    @PostMapping("queryByCompany")
    DataResult queryByCompany(@RequestBody CompanyDTO companyDTO){
        ArrayList<CompanyVo> companyVos = new ArrayList<CompanyVo>();
        companyDTO.setPage((companyDTO.getPage() - 1) * companyDTO.getLimit());
        List<Company> companies =this.companyService.queryAll(companyDTO);
        Company company = new Company();
        BeanUtils.copyProperties(companyDTO,company);
        Long total = this.companyService.getCompanyByConditionCount(company);
        for(Company company1:companies){
            //查询地址名称
            String addressContent = this.addressService.queryById(company1.getAddressId()).getAddressContent();
            CompanyVo companyVo = new CompanyVo();
            BeanUtils.copyProperties(company1,companyVo);
            companyVo.setAddressContent(addressContent);
            companyVos.add(companyVo);

        }
        return DataResult.successByTotalData(companyVos, total);
    }
//    @PostMapping("queryByCompany")
//    DataResult queryByCompany(@RequestBody CompanyDTO companyDTO){
//        companyDTO.setPage((companyDTO.getPage() - 1) * companyDTO.getLimit());
//        List<Company> companies =this.companyService.queryAll(companyDTO);
//        Company company = new Company();
//        BeanUtils.copyProperties(companyDTO,company);
//        Long total = this.companyService.getCompanyByConditionCount(company);
//        return DataResult.successByTotalData(companies, total);
//    }
}

