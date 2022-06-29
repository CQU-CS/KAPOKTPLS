package com.cqu.kapok.kapoktpls.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Certificate)实体类
 *
 * @author makejava
 * @since 2022-06-28 12:07:05
 */
public class Certificate implements Serializable {
    private static final long serialVersionUID = -87255087095533690L;
    /**
     * 证件id
     */
    private Integer certificateId;
    /**
     * 员工id
     */
    private Integer personId;
    /**
     * 证件类型
     */
    private String certificateType;
    /**
     * 证件办理单位
     */
    private String certificateHandlingUnit;
    /**
     * 证件办理时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date certificateHandlingTime;


    public Integer getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Integer certificateId) {
        this.certificateId = certificateId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateHandlingUnit() {
        return certificateHandlingUnit;
    }

    public void setCertificateHandlingUnit(String certificateHandlingUnit) {
        this.certificateHandlingUnit = certificateHandlingUnit;
    }

    public Date getCertificateHandlingTime() {
        return certificateHandlingTime;
    }

    public void setCertificateHandlingTime(Date certificateHandlingTime) {
        this.certificateHandlingTime = certificateHandlingTime;
    }

}

