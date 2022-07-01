package com.cqu.kapok.kapoktpls.dto;

import com.cqu.kapok.kapoktpls.entity.Notice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDTO extends Notice {
    private int page;
    private int size;
}
