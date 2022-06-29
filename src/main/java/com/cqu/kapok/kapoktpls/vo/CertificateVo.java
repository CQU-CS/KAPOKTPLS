package com.cqu.kapok.kapoktpls.vo;

import com.cqu.kapok.kapoktpls.entity.Certificate;
import lombok.Data;

@Data
public class CertificateVo extends Certificate {
    private String personName;//证件对应人的名字
}
