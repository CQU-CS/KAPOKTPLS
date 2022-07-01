package com.cqu.kapok.kapoktpls.dto;

import com.cqu.kapok.kapoktpls.entity.MaterialUse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialUseDTO extends MaterialUse {
    private int page;
    private int size;
}
