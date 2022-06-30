package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.TruckDTO;
import com.cqu.kapok.kapoktpls.dto.TruckPurchaseDTO;
import com.cqu.kapok.kapoktpls.entity.Company;
import com.cqu.kapok.kapoktpls.entity.Person;
import com.cqu.kapok.kapoktpls.entity.Truck;
import com.cqu.kapok.kapoktpls.entity.TruckPurchase;
import com.cqu.kapok.kapoktpls.service.CompanyService;
import com.cqu.kapok.kapoktpls.service.TruckPurchaseService;
import com.cqu.kapok.kapoktpls.service.TruckService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.utils.result.code.Code;
import com.cqu.kapok.kapoktpls.vo.TruckPurchaseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TruckPurchase)表控制层
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
@RestController
@RequestMapping("truckPurchase")
public class TruckPurchaseController {
    /**
     * 服务对象
     */
    @Resource
    private TruckPurchaseService truckPurchaseService;
    @Resource
    private TruckService truckService;
    @Resource
    private CompanyService companyService;

    /**
     * 分页查询
     *
     * @param truckPurchase 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TruckPurchase>> queryByPage(TruckPurchase truckPurchase, PageRequest pageRequest) {
        return ResponseEntity.ok(this.truckPurchaseService.queryByPage(truckPurchase, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TruckPurchase> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.truckPurchaseService.queryById(id));
    }

    /**
     * 通过实体类查询
     *
     * @param truckPurchase
     * @return
     */
    @PostMapping("queryByTruckPurchase")
    public DataResult<List<TruckPurchase>> queryByTruckPurchase(TruckPurchase truckPurchase){
        return DataResult.successByDatas(this.truckPurchaseService.queryByTruck(truckPurchase));
    }

    /**
     * 新增数据
     *
     * @param truckPurchaseVo 实体
     * @return 新增结果
     */
    @PostMapping("addByTruckPurchase")
    public DataResult add(@RequestBody TruckPurchaseVo truckPurchaseVo) {
        TruckPurchase truckPurchase = new TruckPurchase();
        Truck truck = new Truck();
        Company company = new Company();
        BeanUtils.copyProperties(truckPurchaseVo,truckPurchase);
        if(truckPurchaseVo.getTruckPlate()!=null){
            truck.setTruckPlate(truckPurchaseVo.getTruckPlate());
            List<Truck> trucks = this.truckService.queryByTruck(truck);
            if(trucks.size() !=0){
                for(Truck truck1:trucks){
                    truckPurchase.setTruckId(truck1.getTruckId());
                }
            }else{
                truck.setTruckType("-------");
                Truck insert = this.truckService.insert(truck);
                truckPurchase.setTruckId(insert.getTruckId());
            }
        }
        if(truckPurchaseVo.getCompanyName()!=null){
            company.setCompanyName(truckPurchaseVo.getCompanyName());
            List<Company> companies = this.companyService.queryCompany(company);
            if(companies.size()!=0){
                for(Company company1:companies){
                    truckPurchase.setCompanyId(company1.getCompanyId());
                }
            }else{
                company.setCompanyInstruction("未知业");
                Company insert = this.companyService.insert(company);
                truckPurchase.setCompanyId(insert.getCompanyId());
            }
        }

        return DataResult.successByData(this.truckPurchaseService.insert(truckPurchase));
    }

    /**
     * 编辑数据
     *
     * @param truckPurchaseVo 实体
     * @return 编辑结果
     */
    @PostMapping("editByTrucKPurchase")
    public DataResult edit(@RequestBody TruckPurchaseVo truckPurchaseVo) {
        TruckPurchase truckPurchase = new TruckPurchase();
        Truck truck = new Truck();
        Company company = new Company();
        BeanUtils.copyProperties(truckPurchaseVo,truckPurchase);
        if(truckPurchaseVo.getTruckPlate()!=null){
            truck.setTruckPlate(truckPurchaseVo.getTruckPlate());
            List<Truck> trucks = this.truckService.queryByTruck(truck);
            if(trucks.size() !=0){
                for(Truck truck1:trucks){
                    truckPurchase.setTruckId(truck1.getTruckId());
                }
            }else{
                truck.setTruckType("--------");
                Truck insert = this.truckService.insert(truck);
                truckPurchase.setTruckId(insert.getTruckId());
            }
        }
        if(truckPurchaseVo.getCompanyName()!=null){
            company.setCompanyName(truckPurchaseVo.getCompanyName());
            List<Company> companies = this.companyService.queryCompany(company);
            if(companies.size()!=0){
                for(Company company1:companies){
                    truckPurchase.setCompanyId(company1.getCompanyId());
                }
            }else{
                company.setCompanyInstruction("未知业");
                Company insert = this.companyService.insert(company);
                truckPurchase.setCompanyId(insert.getCompanyId());
            }
        }
        return DataResult.successByData(this.truckPurchaseService.update(truckPurchase));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteByTruckPurchase")
    public DataResult deleteById(Integer id) {
        try{
            boolean b = this.truckPurchaseService.deleteById(id);
        } catch (Exception e){
        }
        return DataResult.errByErrCode(Code.SUCCESS);
    }

    /**
     * 通过truckPurchaseDTO分类查询
     *
     * @param truckPurchaseDTO
     * @return
     */
    @PostMapping("queryByTruckPurchaseDTO")
    DataResult queryByTruckPurchaseDTO(@RequestBody TruckPurchaseDTO truckPurchaseDTO){
        truckPurchaseDTO.setPage((truckPurchaseDTO.getPage() - 1) * truckPurchaseDTO.getLimit());
        List<TruckPurchase> truckPurchases =this.truckPurchaseService.queryByTruckPurchaseDTO(truckPurchaseDTO);
        TruckPurchase truckPurchase = new TruckPurchase();
        BeanUtils.copyProperties(truckPurchaseDTO,truckPurchase);
        Long total = this.truckPurchaseService.getTruckPurchaseByConditionCount(truckPurchase);
        return DataResult.successByTotalData(truckPurchases, total);
    }
}

