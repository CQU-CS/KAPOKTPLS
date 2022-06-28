package com.cqu.kapok.kapoktpls.entity;

import java.io.Serializable;

/**
 * (MaterialInventory)实体类
 *
 * @author makejava
 * @since 2022-06-28 21:19:34
 */
public class MaterialInventory implements Serializable {
    private static final long serialVersionUID = -40615325484584812L;
    /**
     * 物资库存id
     */
    private Integer materialInventoryId;
    /**
     * 物资ID
     */
    private Integer materialId;
    /**
     * 地址ID
     */
    private Integer addressId;
    /**
     * 库存数量
     */
    private Integer materialInventoryNum;


    public Integer getMaterialInventoryId() {
        return materialInventoryId;
    }

    public void setMaterialInventoryId(Integer materialInventoryId) {
        this.materialInventoryId = materialInventoryId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getMaterialInventoryNum() {
        return materialInventoryNum;
    }

    public void setMaterialInventoryNum(Integer materialInventoryNum) {
        this.materialInventoryNum = materialInventoryNum;
    }

}

