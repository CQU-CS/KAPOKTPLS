package com.cqu.kapok.kapoktpls.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Advertisement)实体类
 *
 * @author makejava
 * @since 2022-06-28 08:56:08
 */
public class Advertisement implements Serializable {
    private static final long serialVersionUID = 489688874077820258L;
    /**
     * 广告ID
     */
    private Integer advertisementId;
    /**
     * 广告内容
     */
    private String advertisementContent;
    /**
     * 广告图路径
     */
    private String advertisementPicture;
    /**
     * 广告开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date advertisementStartTime;
    /**
     * 广告结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date advertisementEndTime;


    public Integer getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(Integer advertisementId) {
        this.advertisementId = advertisementId;
    }

    public String getAdvertisementContent() {
        return advertisementContent;
    }

    public void setAdvertisementContent(String advertisementContent) {
        this.advertisementContent = advertisementContent;
    }

    public String getAdvertisementPicture() {
        return advertisementPicture;
    }

    public void setAdvertisementPicture(String advertisementPicture) {
        this.advertisementPicture = advertisementPicture;
    }

    public Date getAdvertisementStartTime() {
        return advertisementStartTime;
    }

    public void setAdvertisementStartTime(Date advertisementStartTime) {
        this.advertisementStartTime = advertisementStartTime;
    }

    public Date getAdvertisementEndTime() {
        return advertisementEndTime;
    }

    public void setAdvertisementEndTime(Date advertisementEndTime) {
        this.advertisementEndTime = advertisementEndTime;
    }

}

