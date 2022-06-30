package com.cqu.kapok.kapoktpls.vo;

import com.cqu.kapok.kapoktpls.entity.Truck;
import lombok.Data;

@Data
public class TruckVo extends Truck {
    private String personName;// 驾驶人姓名
}
