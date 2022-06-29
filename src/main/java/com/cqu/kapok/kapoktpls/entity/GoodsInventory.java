package com.cqu.kapok.kapoktpls.entity;

import java.io.Serializable;

/**
 * (GoodsInventory)实体类
 *
 * @author makejava
 * @since 2022-06-28 17:21:08
 */
public class GoodsInventory implements Serializable {
    private static final long serialVersionUID = 236018616445731951L;
    /**
     * 货物库存ID
     */
    private Integer goodsInventoryId;
    /**
     * 货物ID
     */
    private Integer goodsId;
    /**
     * 地址ID
     */
    private Integer addressId;
    /**
     * 货物库存数量
     */
    private Integer goodsInventoryNum;


    public Integer getGoodsInventoryId() {
        return goodsInventoryId;
    }

    public void setGoodsInventoryId(Integer goodsInventoryId) {
        this.goodsInventoryId = goodsInventoryId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getGoodsInventoryNum() {
        return goodsInventoryNum;
    }

    public void setGoodsInventoryNum(Integer goodsInventoryNum) {
        this.goodsInventoryNum = goodsInventoryNum;
    }

}

