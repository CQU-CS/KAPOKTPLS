package com.cqu.kapok.kapoktpls.vo;

import com.cqu.kapok.kapoktpls.entity.GoodsSale;
import lombok.Data;

@Data
public class GoodsSaleVo extends GoodsSale {
	private String goodsName;
	private String companyName;
}
