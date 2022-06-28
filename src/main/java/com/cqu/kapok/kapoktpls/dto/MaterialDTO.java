package com.cqu.kapok.kapoktpls.dto;

import com.cqu.kapok.kapoktpls.entity.Material;
import lombok.Data;

@Data
public class MaterialDTO extends Material {
	private long page;//当前页码
	private long limit;//每页条数
}
