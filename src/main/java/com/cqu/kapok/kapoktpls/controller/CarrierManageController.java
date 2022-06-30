package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.CarrierDTO;
import com.cqu.kapok.kapoktpls.dto.CarrierManageDTO;
import com.cqu.kapok.kapoktpls.entity.*;
import com.cqu.kapok.kapoktpls.service.*;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.utils.result.code.Code;
import com.cqu.kapok.kapoktpls.vo.CarrierManageVo;
import com.cqu.kapok.kapoktpls.vo.CompanyVo;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (CarrierManage)表控制层
 *
 * @author makejava
 * @since 2022-06-28 10:46:00
 */
@RestController
@RequestMapping("carrierManage")
public class CarrierManageController {
    /**
     * 服务对象
     */
    @Resource
    private CarrierManageService carrierManageService;
    @Resource
    private CarrierService carrierService;
    @Resource
    private CompanyService companyService;
    @Resource
    private TransportationTaskService transportationTaskService;
    @Resource
    private GoodsService goodsService;
    /**
     * 分页查询
     *
     * @param carrierManage 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<CarrierManage>> queryByPage(CarrierManage carrierManage, PageRequest pageRequest) {
        return ResponseEntity.ok(this.carrierManageService.queryByPage(carrierManage, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<CarrierManage> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.carrierManageService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param carrierManageVo 实体
     * @return 新增结果
     */
    @PostMapping("addByCarrierManage")
    public DataResult add(@RequestBody CarrierManageVo carrierManageVo) {
        CarrierManage carrierManage = new CarrierManage();
        Company company = new Company();
        Goods goods = new Goods();
        TransportationTask transportationTask = new TransportationTask();
        Carrier carrier = new Carrier();
        BeanUtils.copyProperties(carrierManageVo,carrierManage);
        if(carrierManageVo.getCarrierName()!=null){
            carrier.setCarrierName(carrierManageVo.getCarrierName());
            List<Carrier> carriers = this.carrierService.queryByCarrier(carrier);
            if(carriers.size()==0){
                carrier.setCarrierInformation("new carrier");
                Carrier insert = this.carrierService.insert(carrier);
                carrierManage.setCarrierId(insert.getCarrierId());
            }else{
                for(Carrier carrier1:carriers){
                    carrierManage.setCarrierId(carrier1.getCarrierId());
                }
            }
        }
        if(carrierManageVo.getCompanyName()!=null){
            company.setCompanyName(carrierManageVo.getCompanyName());
            List<Company> companies = this.companyService.queryCompany(company);
            if(companies.size()==0){
                company.setAddressId(666);
                Company insert = this.companyService.insert(company);
                transportationTask.setCompanyId(insert.getCompanyId());
            }else{
                for(Company company1:companies){
                    transportationTask.setCompanyId(company1.getCompanyId());
                }
            }

        }
        if(carrierManageVo.getGoodsName()!=null){
            goods.setGoodsName(carrierManageVo.getGoodsName());
            List<Goods> goods1 = this.goodsService.queryByGoods(goods);
            if(goods1.size()==0){
                goods.setGoodsType("new goods");
                Goods insert = this.goodsService.insert(goods);
                transportationTask.setGoodsId(insert.getGoodsId());

            }else{
                for(Goods goods2:goods1){
                    transportationTask.setGoodsId(goods2.getGoodsId());;
                }
            }

        }
        transportationTask.setTransportationTaskEndTime(carrierManageVo.getTaskTime());
        transportationTask.setTruckId(666);
        transportationTask.setAddressId(666);
        TransportationTask insert = this.transportationTaskService.insert(transportationTask);
        carrierManage.setTransportationTaskId(insert.getTransportationTaskId());;
        return DataResult.successByData(this.carrierManageService.insert(carrierManage));
    }

    /**
     * 编辑数据
     *
     * @param carrierManageVo 实体
     * @return 编辑结果
     */
    @PostMapping("editByCarrierManage")
    public DataResult edit(@RequestBody CarrierManageVo carrierManageVo) {
        System.out.println(carrierManageVo.getCarrierName());
        CarrierManage carrierManage = new CarrierManage();
        Company company = new Company();
        Goods goods = new Goods();
        TransportationTask transportationTask = new TransportationTask();
        Carrier carrier = new Carrier();
        BeanUtils.copyProperties(carrierManageVo,carrierManage);
        if(carrierManageVo.getCarrierName()!=null){
            carrier.setCarrierName(carrierManageVo.getCarrierName());
            List<Carrier> carriers = this.carrierService.queryByCarrier(carrier);
            if(carriers.size()==0){
                carrier.setCarrierInformation("new carrier");
                Carrier insert = this.carrierService.insert(carrier);
                carrierManage.setCarrierId(insert.getCarrierId());
            }else{
                for(Carrier carrier1:carriers){
                    carrierManage.setCarrierId(carrier1.getCarrierId());
                }
            }
        }
        if(carrierManageVo.getCompanyName()!=null){
            company.setCompanyName(carrierManageVo.getCompanyName());
            List<Company> companies = this.companyService.queryCompany(company);
            if(companies.size()==0){
                company.setAddressId(666);
                Company insert = this.companyService.insert(company);
                transportationTask.setCompanyId(insert.getCompanyId());
            }else{
                for(Company company1:companies){
                    transportationTask.setCompanyId(company1.getCompanyId());
                }
            }

        }
        if(carrierManageVo.getGoodsName()!=null){
            goods.setGoodsName(carrierManageVo.getGoodsName());
            List<Goods> goods1 = this.goodsService.queryByGoods(goods);
            if(goods1.size()==0){
                goods.setGoodsType("new goods");
                Goods insert = this.goodsService.insert(goods);
                transportationTask.setGoodsId(insert.getGoodsId());

            }else{
                for(Goods goods2:goods1){
                    transportationTask.setGoodsId(goods2.getGoodsId());;
                }
            }

        }
        transportationTask.setTransportationTaskEndTime(carrierManageVo.getTaskTime());
        transportationTask.setTruckId(666);
        transportationTask.setAddressId(666);
        TransportationTask insert = this.transportationTaskService.insert(transportationTask);
        carrierManage.setTransportationTaskId(insert.getTransportationTaskId());;
        return DataResult.successByData(this.carrierManageService.update(carrierManage));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteByCarrierManageId")
    public DataResult deleteById(Integer id) {
        boolean b = this.carrierManageService.deleteById(id);
        return DataResult.errByErrCode(Code.SUCCESS);
    }
    /**
     * 通过CarrierManageDTO分页查询
     * @param carrierManageDTO
     * @return 查询结果列表和查询总数
     */
    @PostMapping("queryByCarrierManage")
    DataResult queryByCarrierManage(@RequestBody CarrierManageDTO carrierManageDTO){
        ArrayList<CarrierManageVo> carrierManageVos = new ArrayList<>();
        carrierManageDTO.setPage((carrierManageDTO.getPage() - 1) * carrierManageDTO.getLimit());
        List<CarrierManage> carrierManages =this.carrierManageService.queryAll(carrierManageDTO);
        CarrierManage carrierManage = new CarrierManage();
        BeanUtils.copyProperties(carrierManageDTO,carrierManage);
        Long total = this.carrierManageService.getCarrierMangeByConditionCount(carrierManage);
        for(CarrierManage carrierManage1:carrierManages){
            //查询承运商名称
            String carrierName = this.carrierService.queryById(carrierManage1.getCarrierId()).getCarrierName();
            CarrierManageVo carrierManageVo = new CarrierManageVo();
            //查询发布任务公司名
            Integer companyId = this.transportationTaskService.queryById(carrierManage1.getTransportationTaskId()).getCompanyId();
            String companyName = this.companyService.queryById(companyId).getCompanyName();
            //查询货物名
            Integer goodsId = this.transportationTaskService.queryById(carrierManage1.getTransportationTaskId()).getGoodsId();
            String goodsName = this.goodsService.queryById(goodsId).getGoodsName();
           //查询运输开始时间
            Date transportationTaskEndTime = this.transportationTaskService.queryById(carrierManage1.getTransportationTaskId()).getTransportationTaskEndTime();

            BeanUtils.copyProperties(carrierManage1,carrierManageVo);
            carrierManageVo.setCarrierName(carrierName);
            carrierManageVo.setCompanyName(companyName);
            carrierManageVo.setGoodsName(goodsName);
            carrierManageVo.setTaskTime(transportationTaskEndTime);
            carrierManageVos.add(carrierManageVo);
        }
        return DataResult.successByTotalData(carrierManageVos, total);
    }

}

