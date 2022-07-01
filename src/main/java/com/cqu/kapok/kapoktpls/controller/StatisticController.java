package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.entity.Person;
import com.cqu.kapok.kapoktpls.service.*;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.utils.result.code.Code;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @
 * @Description 图表数据统计
 * @Author 卓钊
 * @Date 2022/7/1 11:26
 * @Version 1.0
 **/
@RestController
@RequestMapping("statistic")
@CrossOrigin
public class StatisticController {
    @Resource
    private TransportationTaskService transportationTaskService;
    @Resource
    private CarrierManageService carrierManageService;
    @Resource
    private BuildingSaleService buildingSaleService;
    @Resource
    private BuildingRentService buildingRentService;
    @Resource
    private TruckSaleService truckSaleService;
    @Resource
    private TruckPurchaseService truckPurchaseService;
    @Resource
    private GoodsSaleService goodsSaleService;
    @Resource
    private MaterialPurchaseService materialPurchaseService;
    @Resource
    private MaterialSaleService materialSaleService;
    @Resource
    private GoodsPurchaseService goodsPurchaseService;
    @Resource
    private PersonService personService;

    /**
     * 获取首页数据
     * @return
     */
    @PostMapping("getIndexStatistic")
    public DataResult getIndexStatistic(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(dateString);
        long tmp;
        //本月建筑出售收入
        long buildingSalePrice = 0;
        if(this.buildingSaleService.getMonthPrice(date)!=null){
            buildingSalePrice = this.buildingSaleService.getMonthPrice(date);
        }
        //本月建筑出租收入
        long buildingRentPrice = 0;
        if(this.buildingRentService.getMonthPrice(date)!=null){
            buildingRentPrice = this.buildingRentService.getMonthPrice(date);
        }
        //本月商品出售收入
        long goodSalePrice = 0;
        if(this.goodsSaleService.getMonthPrice(date)!=null){
            goodSalePrice = this.goodsSaleService.getMonthPrice(date);
        }
        //本月物资出售收入
        long materialPrice = 0;
        if(this.materialSaleService.getMonthPrice(date)!=null){
            materialPrice = this.materialSaleService.getMonthPrice(date);
        }
        //本月运输收入
        long transpositionPrice = 0;
        if(this.transportationTaskService.getProfit(date)!=null){
            transpositionPrice = this.transportationTaskService.getProfit(date);
        }
        //本月汽车出售收入
        long truckSalePrice = 0;
        if(this.truckSaleService.getMonthProfit(date)!=null){
            truckSalePrice = this.truckSaleService.getMonthProfit(date);
        }

        //本月商品购买支出
        long goodPurchesePrice = 0;
        if(this.goodsPurchaseService.getMonthPrice(date)!=null){
            goodPurchesePrice = this.goodsPurchaseService.getMonthPrice(date);
        }
        //本月物资购买支出
        long materialPurchesePrice = 0;
        if(this.materialPurchaseService.getMonthPrice(date)!=null){
            materialPurchesePrice = this.materialPurchaseService.getMonthPrice(date);
        }
        //本月汽车购买支出
        long truckPurchasePrice = 0;
        if(this.truckPurchaseService.getMonthCost(date)!=null){
            truckPurchasePrice = this.truckPurchaseService.getMonthCost(date);
        }

        //本月运输任务次数
        long trips = this.transportationTaskService.getTrips(date);

        //员工总数
        long personNum = this.personService.count(new Person());

        //总收入
        long totalIncome = buildingSalePrice+buildingRentPrice+goodSalePrice+materialPrice+transpositionPrice+truckSalePrice;
        //总支出
        long totalExpenditures = goodPurchesePrice+materialPurchesePrice+truckPurchasePrice;

        Map<String,Long> map = new HashMap<>();
        map.put("totalIncome",totalIncome);
        map.put("totalExpenditures",totalExpenditures);
        map.put("trips",trips);
        map.put("personNum",personNum);


        return DataResult.successByData(map);
    }

    /**
     * 测试
     * @return
     */
    @PostMapping("test")
    public Long test(String dateString){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Long buildingSalePrice = -1l;
        try {
            Date newTime = format.parse(dateString);
            buildingSalePrice = this.transportationTaskService.getProfit(newTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }finally {
            return buildingSalePrice;
        }
    }

}
