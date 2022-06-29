package com.cqu.kapok.kapoktpls.dto;

import com.cqu.kapok.kapoktpls.entity.Truck;
import lombok.Data;

@Data
public class TruckDTO extends Truck {
    private long page;//当前页码
    private long limit;//每页条数
}
