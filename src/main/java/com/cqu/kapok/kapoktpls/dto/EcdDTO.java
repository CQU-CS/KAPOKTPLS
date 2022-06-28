package com.cqu.kapok.kapoktpls.dto;

import com.cqu.kapok.kapoktpls.entity.Ecd;
import lombok.Data;

@Data
public class EcdDTO extends Ecd {
    private long page;//当前页码
    private long limit;//每页条数
}
