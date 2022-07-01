package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.service.BuildingRentService;
import com.cqu.kapok.kapoktpls.service.BuildingSaleService;
import com.cqu.kapok.kapoktpls.service.CarrierManageService;
import com.cqu.kapok.kapoktpls.service.TransportationTaskService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.utils.result.code.Code;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    /**
     * 获取首页数据
     * @return
     */
    @PostMapping("getIndexStatistic")
    public DataResult getIndexStatistic(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(dateString);
        //本月建筑出售收入
        Long buildingSalePrice = this.buildingSaleService.getMonthPrice(date);
        //本月建筑出租收入
        Long buildingRentPrice = this.buildingRentService.getMonthPrice(date);
        //本月商品出售收入

        //本月物资出售收入

        //本月运输收入

        //本月汽车购买收入


        //本月商品购买支出

        //本月物资购买支出

        //本月运营商支出

        //本月汽车购买支出

        return DataResult.successByData(Code.SUCCESS);
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
            buildingSalePrice = this.buildingSaleService.getMonthPrice(newTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }finally {
            return buildingSalePrice;
        }


    }

}
