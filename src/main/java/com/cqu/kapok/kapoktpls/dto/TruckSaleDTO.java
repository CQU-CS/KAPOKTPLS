package com.cqu.kapok.kapoktpls.dto;

import com.cqu.kapok.kapoktpls.entity.TruckSale;
import lombok.Data;

@Data
public class TruckSaleDTO extends TruckSale {
    private long page;//当前页码
    private long limit;//每页条数
}
