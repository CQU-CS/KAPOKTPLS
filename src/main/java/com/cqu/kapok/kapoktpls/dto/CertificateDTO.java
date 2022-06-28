package com.cqu.kapok.kapoktpls.dto;

import com.cqu.kapok.kapoktpls.entity.Certificate;
import lombok.Data;

@Data
public class CertificateDTO extends Certificate {
    private long page;//当前页码
    private long limit;//每页条数
}
