package com.cqu.kapok.kapoktpls.dto;

import com.cqu.kapok.kapoktpls.entity.Goods;
import com.cqu.kapok.kapoktpls.entity.GoodsSale;
import lombok.Data;

@Data
public class GoodsSaleDTO extends GoodsSale {
	private long page;//当前页码
	private long limit;//每页条数
}
