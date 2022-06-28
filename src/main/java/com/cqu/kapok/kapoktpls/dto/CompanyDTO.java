package com.cqu.kapok.kapoktpls.dto;

import com.cqu.kapok.kapoktpls.entity.Company;
import lombok.Data;

@Data
public class CompanyDTO extends Company {
    private long page;//当前页码
    private long limit;//每页条数
}
