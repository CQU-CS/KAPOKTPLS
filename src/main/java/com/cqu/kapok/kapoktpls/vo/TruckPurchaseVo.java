package com.cqu.kapok.kapoktpls.vo;

import com.cqu.kapok.kapoktpls.entity.TruckPurchase;
import lombok.Data;

@Data
public class TruckPurchaseVo extends TruckPurchase {
    private String truckPlate;  // 车牌号
    private String companyName; // 公司名
}
