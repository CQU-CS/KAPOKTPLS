package com.cqu.kapok.kapoktpls.vo;

import com.cqu.kapok.kapoktpls.entity.TransportationTask;
import lombok.Data;

@Data
public class TransportationTaskVo extends TransportationTask {
    private String truckPlate;  // 车牌号
    private String companyName; // 公司名
    private String goodsName;   // 货物名
    private String addressContent;  // 地址
}
