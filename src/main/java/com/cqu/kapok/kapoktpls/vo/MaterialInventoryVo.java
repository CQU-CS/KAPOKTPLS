package com.cqu.kapok.kapoktpls.vo;

import com.cqu.kapok.kapoktpls.entity.MaterialInventory;
import lombok.Data;

@Data
public class MaterialInventoryVo extends MaterialInventory {
	private String materialName;
	private String addressContent;
}
