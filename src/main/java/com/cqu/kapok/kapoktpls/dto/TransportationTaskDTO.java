package com.cqu.kapok.kapoktpls.dto;

import com.cqu.kapok.kapoktpls.entity.TransportationTask;
import lombok.Data;

@Data
public class TransportationTaskDTO extends TransportationTask {
    private long page;//当前页码
    private long limit;//每页条数
}
