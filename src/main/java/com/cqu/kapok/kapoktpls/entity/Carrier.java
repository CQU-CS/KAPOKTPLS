package com.cqu.kapok.kapoktpls.entity;

import java.io.Serializable;

/**
 * (Carrier)实体类
 *
 * @author makejava
 * @since 2022-06-28 09:05:49
 */
public class Carrier implements Serializable {
    private static final long serialVersionUID = 268174688998140034L;
    /**
     * 承运商ID
     */
    private Integer carrierId;
    /**
     * 承运商名字
     */
    private String carrierName;
    /**
     * 承运商账号
     */
    private String carrierAccount;
    /**
     * 承运商信息
     */
    private String carrierInformation;


    public Integer getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getCarrierAccount() {
        return carrierAccount;
    }

    public void setCarrierAccount(String carrierAccount) {
        this.carrierAccount = carrierAccount;
    }

    public String getCarrierInformation() {
        return carrierInformation;
    }

    public void setCarrierInformation(String carrierInformation) {
        this.carrierInformation = carrierInformation;
    }

}

