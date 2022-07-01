package com.cqu.kapok.kapoktpls.vo;

import com.cqu.kapok.kapoktpls.entity.BuildingRent;
import lombok.Data;

/**
 * @
 * @Description
 * @Author 卓钊
 * @Date 2022/6/30 15:52
 * @Version 1.0
 **/
@Data
public class BuildingRentVo extends BuildingRent {
    String addressContent;  //地址内容
    String buildingType;  //建筑类型
    String companyName;  //租赁的公司名称
}
