package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.entity.Person;
import com.cqu.kapok.kapoktpls.service.*;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.utils.result.code.Code;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    /**
     * 半年收入
     * @param dateString
     * @return
     * @throws ParseException
     */
    @PostMapping("getHalfYearIncome")
    public DataResult getHalfYearIncome(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(dateString);
        //获取前半年日期
        Date date1 = stepMonth(date,-1);
        Date date2 = stepMonth(date,-2);
        Date date3 = stepMonth(date,-3);
        Date date4 = stepMonth(date,-4);
        Date date5 = stepMonth(date,-5);
        //根据日期获取值
        long totalIncome = getTotalIncome(date);
        long totalIncome1 = getTotalIncome(date1);
        long totalIncome2 = getTotalIncome(date2);
        long totalIncome3 = getTotalIncome(date3);
        long totalIncome4 = getTotalIncome(date4);
        long totalIncome5 = getTotalIncome(date5);
        //装入列表
        List<Long> longList = new ArrayList<>();
        longList.add(totalIncome);
        longList.add(totalIncome1);
        longList.add(totalIncome2);
        longList.add(totalIncome3);
        longList.add(totalIncome4);
        longList.add(totalIncome5);
        Map<String,Object> map = new HashMap<>();
        map.put("totalIncomes",longList);
        //返回数值
        return DataResult.successByData(map);
    }

    /**
     * 半年总支出
     * @param dateString
     * @return
     * @throws ParseException
     */
    @PostMapping("getHalfYearExpenditures")
    public DataResult getHalfYearExpenditures(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(dateString);
        //获取前半年日期
        Date date1 = stepMonth(date,-1);
        Date date2 = stepMonth(date,-2);
        Date date3 = stepMonth(date,-3);
        Date date4 = stepMonth(date,-4);
        Date date5 = stepMonth(date,-5);
        //根据日期获取值
        long totalExpenditures = getTotalExpenditures(date);
        long totalExpenditures1 = getTotalExpenditures(date1);
        long totalExpenditures2 = getTotalExpenditures(date2);
        long totalExpenditures3 = getTotalExpenditures(date3);
        long totalExpenditures4 = getTotalExpenditures(date4);
        long totalExpenditures5 = getTotalExpenditures(date5);
        //装入列表
        List<Long> longList = new ArrayList<>();
        longList.add(totalExpenditures);
        longList.add(totalExpenditures1);
        longList.add(totalExpenditures2);
        longList.add(totalExpenditures3);
        longList.add(totalExpenditures4);
        longList.add(totalExpenditures5);
        Map<String,Object> map = new HashMap<>();
        map.put("totalExpenditureses",longList);
        //返回数值
        return DataResult.successByData(map);
    }

    /**
     * 获得首页扇形图
     * @param dateString
     * @return
     * @throws ParseException
     */
    @PostMapping("getSectorDiagram")
    public DataResult getSectorDiagram(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(dateString);
        List<Long> longList = new ArrayList<>();
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

        longList.add(buildingSalePrice);
        longList.add(buildingRentPrice);
        longList.add(goodSalePrice);
        longList.add(materialPrice);
        longList.add(transpositionPrice);
        longList.add(truckSalePrice);
        Map<String,Object> map = new HashMap<>();
        map.put("chartList",longList);
        return DataResult.successByData(map);
    }

    /**
     * 某月总收入
     * @param date
     * @return
     */
    public long getTotalIncome(Date date){
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
        //总收入
        long totalIncome = buildingSalePrice+buildingRentPrice+goodSalePrice+materialPrice+transpositionPrice+truckSalePrice;
        return totalIncome;
    }

    public long getTotalExpenditures(Date date){
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
        //总支出
        long totalExpenditures = goodPurchesePrice+materialPurchesePrice+truckPurchasePrice;
        return totalExpenditures;
    }

    /**
     *      * 在给定的日期加上或减去指定月份后的日期
     *      *
     *      * @param sourceDate 原始时间
     *      * @param month      要调整的月份，向前为负数，向后为正数
     *      * @return
     *
     */
    public static Date stepMonth(Date sourceDate, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);
        c.add(Calendar.MONTH, month);
        return c.getTime();
    }

}
