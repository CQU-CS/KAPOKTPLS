package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.TruckRepairRecordDTO;
import com.cqu.kapok.kapoktpls.dto.TruckSaleDTO;
import com.cqu.kapok.kapoktpls.entity.Company;
import com.cqu.kapok.kapoktpls.entity.Truck;
import com.cqu.kapok.kapoktpls.entity.TruckRepairRecord;
import com.cqu.kapok.kapoktpls.entity.TruckSale;
import com.cqu.kapok.kapoktpls.service.CompanyService;
import com.cqu.kapok.kapoktpls.service.TruckSaleService;
import com.cqu.kapok.kapoktpls.service.TruckService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.utils.result.code.Code;
import com.cqu.kapok.kapoktpls.vo.TruckSaleVo;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * (TruckSale)表控制层
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
@RestController
@RequestMapping("truckSale")
public class TruckSaleController {
    /**
     * 服务对象
     */
    @Resource
    private TruckSaleService truckSaleService;
    @Resource
    private TruckService truckService;
    @Resource
    private CompanyService companyService;

    /**
     * 分页查询
     *
     * @param truckSale 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TruckSale>> queryByPage(TruckSale truckSale, PageRequest pageRequest) {
        return ResponseEntity.ok(this.truckSaleService.queryByPage(truckSale, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TruckSale> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.truckSaleService.queryById(id));
    }

    /**
     * 通过实体类查询
     *
     * @param truckSale
     * @return
     */
    @PostMapping("queryByTruckSale")
    public DataResult<List<TruckSale>> queryByTruckSale(TruckSale truckSale){
        return DataResult.successByDatas(this.truckSaleService.queryByTruckSale(truckSale));
    }

    /**
     * 新增数据
     *
     * @param truckSaleVo 实体
     * @return 新增结果
     */
    @PostMapping("addByTruckSale")
    public DataResult add(@RequestBody TruckSaleVo truckSaleVo) {
        TruckSale truckSale = new TruckSale();
        Truck truck = new Truck();
        Company company = new Company();
        BeanUtils.copyProperties(truckSaleVo,truckSale);
        if(truckSaleVo.getTruckPlate()!=null){
            truck.setTruckPlate(truckSaleVo.getTruckPlate());
            List<Truck> trucks = this.truckService.queryByTruck(truck);
            if(trucks.size()!=0){
                for(Truck truck1:trucks){
                    truckSale.setTruckId(truck1.getTruckId());
                }
            }
            else{
                truck.setPersonId(1);
                Truck insert = this.truckService.insert(truck);
                truckSale.setTruckId(insert.getTruckId());
            }
        }
        if(truckSaleVo.getCompanyName()!=null){
            company.setCompanyName(truckSaleVo.getCompanyName());
            List<Company> companies = this.companyService.queryCompany(company);
            if(companies.size()!=0){
                for(Company company1:companies){
                    truckSale.setCompanyId(company1.getCompanyId());
                }
            }else{
                company.setAddressId(1);
                Company insert = this.companyService.insert(company);
                truckSale.setCompanyId(insert.getCompanyId());
            }
        }
        return DataResult.successByData(this.truckSaleService.insert(truckSale));
    }

    /**
     * 编辑数据
     *
     * @param truckSaleVo 实体
     * @return 编辑结果
     */
    @PostMapping("editByTruckSale")
    public DataResult edit(@RequestBody TruckSaleVo truckSaleVo) {
        TruckSale truckSale = new TruckSale();
        Truck truck = new Truck();
        Company company = new Company();
        BeanUtils.copyProperties(truckSaleVo,truckSale);
        if(truckSaleVo.getTruckPlate()!=null){
            truck.setTruckPlate(truckSaleVo.getTruckPlate());
            List<Truck> trucks = this.truckService.queryByTruck(truck);
            if(trucks.size()!=0){
                for(Truck truck1:trucks){
                    truckSale.setTruckId(truck1.getTruckId());
                }
            }
            else{
                truck.setPersonId(1);
                Truck insert = this.truckService.insert(truck);
                truckSale.setTruckId(insert.getTruckId());
            }
        }
        if(truckSaleVo.getCompanyName()!=null){
            company.setCompanyName(truckSaleVo.getCompanyName());
            List<Company> companies = this.companyService.queryCompany(company);
            if(companies.size()!=0){
                for(Company company1:companies){
                    truckSale.setCompanyId(company1.getCompanyId());
                }
            }else{
                company.setAddressId(1);
                Company insert = this.companyService.insert(company);
                truckSale.setCompanyId(insert.getCompanyId());
            }
        }
        return DataResult.successByData(this.truckSaleService.update(truckSale));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteByTruckSale")
    public DataResult deleteById(Integer id) {
        try{
            boolean b = this.truckSaleService.deleteById(id);
        }catch (Exception e){

        }
        return DataResult.errByErrCode(Code.SUCCESS);
    }

    /**
     * 通过queryByTruckSaleDTO分页查询
     *
     * @param truckSaleDTO
     * @return
     */
    @PostMapping("queryByTruckSaleDTO")
    DataResult queryByTruckSaleDTO(@RequestBody TruckSaleDTO truckSaleDTO){
        ArrayList<TruckSaleVo> truckSaleVos = new ArrayList<>();
        truckSaleDTO.setPage((truckSaleDTO.getPage() - 1) * truckSaleDTO.getLimit());
        List<TruckSale> truckSales =this.truckSaleService.queryByTruckSaleDTO(truckSaleDTO);
        TruckSale truckSale = new TruckSale();
        BeanUtils.copyProperties(truckSaleDTO,truckSale);
        Long total = this.truckSaleService.getTruckSaleByConditionCount(truckSale);
        for(TruckSale truckSale1:truckSales){
            String truckPlate = this.truckService.queryById(truckSale1.getTruckId()).getTruckPlate();
            String companyName = this.companyService.queryById(truckSale1.getCompanyId()).getCompanyName();
            TruckSaleVo truckSaleVo = new TruckSaleVo();
            BeanUtils.copyProperties(truckSale1,truckSaleVo);
            truckSaleVo.setTruckPlate(truckPlate);
            truckSaleVo.setCompanyName(companyName);
            truckSaleVos.add(truckSaleVo);
        }
        return DataResult.successByTotalData(truckSaleVos, total);
    }
}

