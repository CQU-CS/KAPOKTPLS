package com.cqu.kapok.kapoktpls.dto;

import com.cqu.kapok.kapoktpls.entity.RepairRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepairRecordDTO extends RepairRecord {
    private int size;
    private int page;
}
