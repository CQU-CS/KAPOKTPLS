package com.cqu.kapok.kapoktpls.vo;

import com.cqu.kapok.kapoktpls.entity.CarrierManage;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class CarrierManageVo extends CarrierManage {
    private String carrierName;//承运商公司名
    private String companyName;//发布任务公司名
    private String goodsName;//货物名
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")

    private Date taskTime;
}
