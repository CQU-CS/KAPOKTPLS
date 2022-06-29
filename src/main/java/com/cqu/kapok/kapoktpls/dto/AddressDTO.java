package com.cqu.kapok.kapoktpls.dto;

import com.cqu.kapok.kapoktpls.entity.Address;
import lombok.Data;

/**
 * @
 * @Description
 * @Author 卓钊
 * @Date 2022/6/28 17:03
 * @Version 1.0
 **/
@Data
public class AddressDTO extends Address {
    private long page;//当前页码
    private long limit;//每页条数
}
