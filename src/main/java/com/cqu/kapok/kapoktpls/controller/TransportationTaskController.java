package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.TransportationTaskDTO;
import com.cqu.kapok.kapoktpls.entity.*;
import com.cqu.kapok.kapoktpls.service.*;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.utils.result.code.Code;
import com.cqu.kapok.kapoktpls.vo.TransportationTaskVo;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TransportationTask)表控制层
 *
 * @author makejava
 * @since 2022-06-28 10:12:34
 */
@RestController
@RequestMapping("transportationTask")
public class TransportationTaskController {
    /**
     * 服务对象
     */
    @Resource
    private TransportationTaskService transportationTaskService;
    @Resource
    private TruckService truckService;
    @Resource
    private CompanyService companyService;
    @Resource
    private GoodsService goodsService;
    @Resource
    private AddressService addressService;
    /**
     * 分页查询
     *
     * @param transportationTask 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TransportationTask>> queryByPage(TransportationTask transportationTask, PageRequest pageRequest) {
        return ResponseEntity.ok(this.transportationTaskService.queryByPage(transportationTask, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TransportationTask> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.transportationTaskService.queryById(id));
    }

    /**
     * 根据实体类查询
     *
     * @param transportationTask
     * @return
     */
    @PostMapping("queryByTransportationTask")
    public DataResult<List<TransportationTask>> queryByTransportationTask(TransportationTask transportationTask){
        return DataResult.successByDatas(this.transportationTaskService.queryByTransportationTask(transportationTask));
    }

    /**
     * 新增数据
     *
     * @param transportationTaskVo 实体
     * @return 新增结果
     */
    @PostMapping("addByTransportationTask")
    public DataResult add(TransportationTaskVo transportationTaskVo) {
        TransportationTask transportationTask = new TransportationTask();
        Truck truck = new Truck();
        Company company = new Company();
        Goods goods = new Goods();
        Address address = new Address();
        BeanUtils.copyProperties(transportationTaskVo,transportationTask);
        if(transportationTaskVo.getTruckPlate()!=null){
            truck.setTruckPlate(transportationTaskVo.getTruckPlate());
            List<Truck> trucks = this.truckService.queryByTruck(truck);
            if(trucks.size()!=0){
                for (Truck truck1:trucks){
                    transportationTask.setTruckId(truck1.getTruckId());
                }
            }else{
                truck.setPersonId(1);
                Truck insert = this.truckService.insert(truck);
                transportationTask.setTruckId(insert.getTruckId());
            }
        }
        if(transportationTaskVo.getAddressContent()!=null){
            address.setAddressContent(transportationTaskVo.getAddressContent());
            List<Address> addresses = this.addressService.queryByAddress(address);
            if(addresses.size()!=0){
                for(Address address1:addresses){
                    transportationTask.setAddressId(address1.getAddressId());
                }
            }else{
                address.setAddressLevel(1);
                Address insert = this.addressService.insert(address);
                transportationTask.setAddressId(insert.getAddressId());
            }
        }
        if(transportationTaskVo.getCompanyName()!=null){
            company.setCompanyName(transportationTaskVo.getCompanyName());
            List<Company> companies = this.companyService.queryCompany(company);
            if(companies.size()!=0){
                for (Company company1:companies){
                    transportationTask.setCompanyId(company1.getCompanyId());
                }
            }else{
                company.setAddressId(1);
                Company insert = this.companyService.insert(company);
                transportationTask.setCompanyId(insert.getCompanyId());
            }
        }
        if(transportationTaskVo.getGoodsName()!=null){
            goods.setGoodsName(transportationTaskVo.getGoodsName());
            List<Goods> goods1 = this.goodsService.queryByGoods(goods);
            if(goods1.size()!=0){
                for (Goods goods2:goods1){
                    transportationTask.setGoodsId(goods2.getGoodsId());
                }
            }else{
                goods.setGoodsUnit("--------");
                Goods insert = this.goodsService.insert(goods);
                transportationTask.setGoodsId(insert.getGoodsId());
            }
        }
        return DataResult.successByData(this.transportationTaskService.insert(transportationTask));
    }

    /**
     * 编辑数据
     *
     * @param transportationTaskVo 实体
     * @return 编辑结果
     */
    @PostMapping("editByTransportationTask")
    public DataResult edit(@RequestBody TransportationTaskVo transportationTaskVo) {
        TransportationTask transportationTask = new TransportationTask();
        Truck truck = new Truck();
        Company company = new Company();
        Goods goods = new Goods();
        Address address = new Address();
        BeanUtils.copyProperties(transportationTaskVo,transportationTask);
        if(transportationTaskVo.getTruckPlate()!=null){
            truck.setTruckPlate(transportationTaskVo.getTruckPlate());
            List<Truck> trucks = this.truckService.queryByTruck(truck);
            if(trucks.size()!=0){
                for (Truck truck1:trucks){
                    transportationTask.setTruckId(truck1.getTruckId());
                }
            }else{
                truck.setPersonId(1);
                Truck insert = this.truckService.insert(truck);
                transportationTask.setTruckId(insert.getTruckId());
            }
        }
        if(transportationTaskVo.getAddressContent()!=null){
            address.setAddressContent(transportationTaskVo.getAddressContent());
            List<Address> addresses = this.addressService.queryByAddress(address);
            if(addresses.size()!=0){
                for(Address address1:addresses){
                    transportationTask.setAddressId(address1.getAddressId());
                }
            }else{
                address.setAddressLevel(1);
                Address insert = this.addressService.insert(address);
                transportationTask.setAddressId(insert.getAddressId());
            }
        }
        if(transportationTaskVo.getCompanyName()!=null){
            company.setCompanyName(transportationTaskVo.getCompanyName());
            List<Company> companies = this.companyService.queryCompany(company);
            if(companies.size()!=0){
                for (Company company1:companies){
                    transportationTask.setCompanyId(company1.getCompanyId());
                }
            }else{
                company.setAddressId(1);
                Company insert = this.companyService.insert(company);
                transportationTask.setCompanyId(insert.getCompanyId());
            }
        }
        if(transportationTaskVo.getGoodsName()!=null){
            goods.setGoodsName(transportationTaskVo.getGoodsName());
            List<Goods> goods1 = this.goodsService.queryByGoods(goods);
            if(goods1.size()!=0){
                for (Goods goods2:goods1){
                    transportationTask.setGoodsId(goods2.getGoodsId());
                }
            }else{
                goods.setGoodsUnit("--------");
                Goods insert = this.goodsService.insert(goods);
                transportationTask.setGoodsId(insert.getGoodsId());
            }
        }
        return DataResult.successByData(this.transportationTaskService.update(transportationTask));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteByTransportationTask")
    public DataResult deleteById(Integer id) {
        try{
            boolean b = this.transportationTaskService.deleteById(id);
        } catch (Exception e){
            return DataResult.errByErrCode(Code.TRANSPORTATIONtASK_ERROR);
        }
        return DataResult.errByErrCode(Code.SUCCESS);
    }

    /**
     * 通过TransportationTaskDTO分页查询
     *
     * @param transportationTaskDTO
     * @return
     */
    @PostMapping("queryByTransportationTaskDTO")
    DataResult queryByTransportationTaskDTO(@RequestBody TransportationTaskDTO transportationTaskDTO){
        transportationTaskDTO.setPage((transportationTaskDTO.getPage() - 1) * transportationTaskDTO.getLimit());
        List<TransportationTask> transportationTasks =this.transportationTaskService.queryByTransportationTaskDTO(transportationTaskDTO);
        TransportationTask transportationTask = new TransportationTask();
        BeanUtils.copyProperties(transportationTaskDTO,transportationTask);
        Long total = this.transportationTaskService.getTransportationTaskByConditionCount(transportationTask);
        return DataResult.successByTotalData(transportationTasks, total);
    }

}

