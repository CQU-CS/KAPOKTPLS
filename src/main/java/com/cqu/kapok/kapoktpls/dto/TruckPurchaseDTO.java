package com.cqu.kapok.kapoktpls.dto;

import com.cqu.kapok.kapoktpls.entity.TruckPurchase;
import lombok.Data;

@Data
public class TruckPurchaseDTO extends TruckPurchase {
    private long page;//当前页码
    private long limit;//每页条数
}
