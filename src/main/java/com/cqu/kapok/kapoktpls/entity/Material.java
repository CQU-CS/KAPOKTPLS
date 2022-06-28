package com.cqu.kapok.kapoktpls.entity;

import java.io.Serializable;

/**
 * (Material)实体类
 *
 * @author makejava
 * @since 2022-06-28 10:09:56
 */
public class Material implements Serializable {
    private static final long serialVersionUID = -33037398882944959L;

    private Integer materialId;
    /**
     * 物资名称
     */
    private String materialName;
    /**
     * 物资类型
     */
    private String materialType;
    /**
     * 物资价格
     */
    private Integer materialPrice;
    /**
     * 物资尺寸
     */
    private Integer materialSize;


    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public Integer getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(Integer materialPrice) {
        this.materialPrice = materialPrice;
    }

    public Integer getMaterialSize() {
        return materialSize;
    }

    public void setMaterialSize(Integer materialSize) {
        this.materialSize = materialSize;
    }

}

