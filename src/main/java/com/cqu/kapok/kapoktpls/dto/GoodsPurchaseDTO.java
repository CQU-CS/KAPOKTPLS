package com.cqu.kapok.kapoktpls.dto;

import com.cqu.kapok.kapoktpls.entity.GoodsPurchase;
import lombok.Data;

@Data
public class GoodsPurchaseDTO extends GoodsPurchase {
	private long page;//当前页码
	private long limit;//每页条数
}
