package com.cqu.kapok.kapoktpls.vo;

import com.cqu.kapok.kapoktpls.entity.GoodsInventory;
import lombok.Data;

@Data
public class GoodsInventoryVo extends GoodsInventory {
	private String goodsName;
	private String addressContent;
}
