package com.cqu.kapok.kapoktpls.dto;

import com.cqu.kapok.kapoktpls.entity.GoodsInventory;
import lombok.Data;

@Data
public class GoodsInventoryDTO extends GoodsInventory {
	private long page;//当前页码
	private long limit;//每页条数
}
