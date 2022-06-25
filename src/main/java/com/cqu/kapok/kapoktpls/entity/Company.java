package com.cqu.kapok.kapoktpls.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Company)实体类
 *
 * @author makejava
 * @since 2022-06-25 10:03:24
 */
public class Company implements Serializable {
    private static final long serialVersionUID = 972767332114717156L;
    /**
     * 主键id
     */
    private Integer companyId;
    /**
     * 公司名
     */
    private String companyName;
    /**
     * 联系方式
     */
    private String companyPhone;
    /**
     * 地址id
     */
    private Integer addressId;
    /**
     * 公司简介
     */
    private String companyInstruction;
    /**
     * 公司成立时间
     */
    private Date companyEstablishmentTime;


    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getCompanyInstruction() {
        return companyInstruction;
    }

    public void setCompanyInstruction(String companyInstruction) {
        this.companyInstruction = companyInstruction;
    }

    public Date getCompanyEstablishmentTime() {
        return companyEstablishmentTime;
    }

    public void setCompanyEstablishmentTime(Date companyEstablishmentTime) {
        this.companyEstablishmentTime = companyEstablishmentTime;
    }

}

