package com.cqu.kapok.kapoktpls.dto;

import com.cqu.kapok.kapoktpls.entity.OfficeMaterialPurchase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficeMaterialPurchaseDTO extends OfficeMaterialPurchase {
    private int page;
    private int size;
}
