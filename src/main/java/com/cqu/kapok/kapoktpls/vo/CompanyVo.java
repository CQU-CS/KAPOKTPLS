package com.cqu.kapok.kapoktpls.vo;

import com.cqu.kapok.kapoktpls.entity.Company;
import lombok.Data;

@Data
public class CompanyVo extends Company {
    private String addressContent;//公司对应地址内容
}
