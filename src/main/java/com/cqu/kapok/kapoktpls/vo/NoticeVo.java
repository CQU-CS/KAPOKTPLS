package com.cqu.kapok.kapoktpls.vo;

import com.cqu.kapok.kapoktpls.entity.Notice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeVo extends Notice {
    private String personName;
}
