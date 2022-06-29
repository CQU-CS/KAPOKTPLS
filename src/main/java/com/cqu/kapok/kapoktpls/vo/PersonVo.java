package com.cqu.kapok.kapoktpls.vo;

import com.cqu.kapok.kapoktpls.entity.Person;
import lombok.Data;

/**
 * @
 * @Description
 * @Author 卓钊
 * @Date 2022/6/29 16:15
 * @Version 1.0
 **/
@Data
public class PersonVo extends Person {
    String companyName; //公司名字
    String personGenderString;  //性别字符串
}
