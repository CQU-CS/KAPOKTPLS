package com.cqu.kapok.kapoktpls.vo;

import com.cqu.kapok.kapoktpls.entity.OfficeMaterialPurchase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficeMaterialPurchaseVo extends OfficeMaterialPurchase {
    private String companyName;
}
