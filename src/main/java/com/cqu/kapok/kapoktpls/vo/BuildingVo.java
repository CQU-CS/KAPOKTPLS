package com.cqu.kapok.kapoktpls.vo;

import com.cqu.kapok.kapoktpls.entity.Building;
import lombok.Data;

/**
 * @
 * @Description
 * @Author 卓钊
 * @Date 2022/6/30 11:23
 * @Version 1.0
 **/
@Data
public class BuildingVo extends Building {
    String addressContent;  //地址内容
}
