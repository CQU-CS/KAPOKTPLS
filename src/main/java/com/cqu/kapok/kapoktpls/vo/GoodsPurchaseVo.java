package com.cqu.kapok.kapoktpls.vo;

import com.cqu.kapok.kapoktpls.entity.GoodsPurchase;
import lombok.Data;

@Data
public class GoodsPurchaseVo extends GoodsPurchase {
	private String goodsName;
	private String companyName;
}
