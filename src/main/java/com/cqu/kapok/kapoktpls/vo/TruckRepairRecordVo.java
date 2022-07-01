package com.cqu.kapok.kapoktpls.vo;

import com.cqu.kapok.kapoktpls.entity.TruckRepairRecord;
import lombok.Data;

@Data
public class TruckRepairRecordVo extends TruckRepairRecord {
    private String truckPlate;  // 车牌号
}
