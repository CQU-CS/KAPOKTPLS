package com.cqu.kapok.kapoktpls.vo;

import com.cqu.kapok.kapoktpls.entity.MaterialUse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialUseVo extends MaterialUse {
    private String materialName;
    private String personName;
}
