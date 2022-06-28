package com.cqu.kapok.kapoktpls.dto;

import com.cqu.kapok.kapoktpls.entity.MaterialPurchase;
import lombok.Data;

@Data
public class MaterialPurchaseDTO extends MaterialPurchase {
	private long page;//当前页码
	private long limit;//每页条数
}
