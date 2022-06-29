package com.cqu.kapok.kapoktpls.dto;

import com.cqu.kapok.kapoktpls.entity.Advertisement;
import lombok.Data;

/**
 * @
 * @Description
 * @Author 卓钊
 * @Date 2022/6/29 9:09
 * @Version 1.0
 **/
@Data
public class AdvertisementDTO extends Advertisement {
    private long page;//当前页码
    private long limit;//每页条数
}
