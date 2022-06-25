package com.cqu.kapok.kapoktpls.entity;

import java.io.Serializable;

/**
 * (Address)实体类
 *
 * @author makejava
 * @since 2022-06-25 10:01:16
 */
public class Address implements Serializable {
    private static final long serialVersionUID = 212457987269592908L;
    /**
     * 地址ID
     */
    private Integer addressId;
    /**
     * 地址内容
     */
    private String addressContent;
    /**
     * 地域等级
     */
    private Integer addressLevel;


    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddressContent() {
        return addressContent;
    }

    public void setAddressContent(String addressContent) {
        this.addressContent = addressContent;
    }

    public Integer getAddressLevel() {
        return addressLevel;
    }

    public void setAddressLevel(Integer addressLevel) {
        this.addressLevel = addressLevel;
    }

}

