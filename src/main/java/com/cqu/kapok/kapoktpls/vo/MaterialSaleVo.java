package com.cqu.kapok.kapoktpls.vo;

import com.cqu.kapok.kapoktpls.entity.MaterialSale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialSaleVo extends MaterialSale {
    private String companyName;
    private String materialName;
}
