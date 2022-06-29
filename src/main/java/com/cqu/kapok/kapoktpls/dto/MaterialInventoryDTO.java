package com.cqu.kapok.kapoktpls.dto;

import com.cqu.kapok.kapoktpls.entity.MaterialInventory;
import lombok.Data;

@Data
public class MaterialInventoryDTO extends MaterialInventory {
	private long page;//当前页码
	private long limit;//每页条数
}
