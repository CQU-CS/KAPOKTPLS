package com.cqu.kapok.kapoktpls.dto;

import com.cqu.kapok.kapoktpls.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @
 * @Description
 * @Author 卓钊
 * @Date 2022/6/28 16:47
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO extends Person {
    private int size;
    private int page;
}
