package com.cqu.kapok.kapoktpls.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (MaterialUse)实体类
 *
 * @author makejava
 * @since 2022-06-28 09:43:26
 */
public class MaterialUse implements Serializable {
    private static final long serialVersionUID = -46685816980092752L;
    /**
     * 物资使用ID
     */
    private Integer materialUseId;
    /**
     * 物资ID
     */
    private Integer materialId;
    /**
     * 使用人员ID
     */
    private Integer personId;
    /**
     * 使用数量
     */
    private Integer materialUseNum;
    /**
     * 开始使用时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date materialUseStartTime;
    /**
     * 结束使用时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date materialUseEndTime;


    public Integer getMaterialUseId() {
        return materialUseId;
    }

    public void setMaterialUseId(Integer materialUseId) {
        this.materialUseId = materialUseId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getMaterialUseNum() {
        return materialUseNum;
    }

    public void setMaterialUseNum(Integer materialUseNum) {
        this.materialUseNum = materialUseNum;
    }

    public Date getMaterialUseStartTime() {
        return materialUseStartTime;
    }

    public void setMaterialUseStartTime(Date materialUseStartTime) {
        this.materialUseStartTime = materialUseStartTime;
    }

    public Date getMaterialUseEndTime() {
        return materialUseEndTime;
    }

    public void setMaterialUseEndTime(Date materialUseEndTime) {
        this.materialUseEndTime = materialUseEndTime;
    }

}

