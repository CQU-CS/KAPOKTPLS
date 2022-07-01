package com.cqu.kapok.kapoktpls.vo;

import com.cqu.kapok.kapoktpls.entity.MaterialPurchase;
import lombok.Data;

@Data
public class MaterialPurchaseVo extends MaterialPurchase {
	private String materialName;
	private String companyName;
}
