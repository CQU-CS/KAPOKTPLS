package com.cqu.kapok.kapoktpls.dto;

import com.cqu.kapok.kapoktpls.entity.Carrier;
import lombok.Data;

@Data
public class CarrierDTO extends Carrier {
    private long page;//当前页码
    private long limit;//每页条数
}
