package com.cqu.kapok.kapoktpls.vo;

import com.cqu.kapok.kapoktpls.entity.Account;
import lombok.Data;

/**
 * @
 * @Description
 * @Author 卓钊
 * @Date 2022/7/1 9:17
 * @Version 1.0
 **/
@Data
public class AccountVo extends Account {
    String personName;  //对应员工名
}
