package com.cqu.kapok.kapoktpls.dto;

import com.cqu.kapok.kapoktpls.entity.MaterialSale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialSaleDTO extends MaterialSale {
    private int page;
    private int size;
}
