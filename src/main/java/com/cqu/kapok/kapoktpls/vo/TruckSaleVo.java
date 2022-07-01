package com.cqu.kapok.kapoktpls.vo;

import com.cqu.kapok.kapoktpls.entity.TruckSale;
import lombok.Data;

@Data
public class TruckSaleVo extends TruckSale {
    private String truckPlate;  // 车牌号
    private String companyName; // 公司名
}
