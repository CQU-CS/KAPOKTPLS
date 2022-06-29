package com.cqu.kapok.kapoktpls.dto;

import com.cqu.kapok.kapoktpls.entity.TruckRepairRecord;
import lombok.Data;

@Data
public class TruckRepairRecordDTO extends TruckRepairRecord {
    private long page;//当前页码
    private long limit;//每页条数
}
