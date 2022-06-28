package com.cqu.kapok.kapoktpls.dto;

import com.cqu.kapok.kapoktpls.entity.CarrierManage;
import lombok.Data;

@Data
public class CarrierManageDTO extends CarrierManage {
    private long page;//当前页码
    private long limit;//每页条数
}
