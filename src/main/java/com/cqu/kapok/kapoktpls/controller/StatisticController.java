package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.service.CarrierManageService;
import com.cqu.kapok.kapoktpls.service.TransportationTaskService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.utils.result.code.Code;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    /**
     * 获取首页数据
     * @return
     */
    @PostMapping("getIndexStatistic")
    public DataResult getIndexStatistic(){
        return DataResult.successByData(Code.SUCCESS);
    }

}
