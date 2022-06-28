package com.cqu.kapok.kapoktpls.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TransportationTask)实体类
 *
 * @author makejava
 * @since 2022-06-28 10:12:34
 */
public class TransportationTask implements Serializable {
    private static final long serialVersionUID = 478655305095713851L;
    /**
     * 运输任务编号
     */
    private Integer transportationTaskId;
    /**
     * 运输汽车编号
     */
    private Integer truckId;
    /**
     * 公司编号
     */
    private Integer companyId;
    /**
     * 货物编号
     */
    private Integer goodsId;
    /**
     * 货物数量
     */
    private Integer transportationTaskGoodsNum;
    /**
     * 始发地编号
     */
    private Integer addressId;
    /**
     * 目的地地址
     */
    private String transportationTaskDestination;
    /**
     * 运输任务开始时间
     */
    private Date transportationTaskStartTime;
    /**
     * 运输任务结束时间
     */
    private Date transportationTaskEndTime;
    /**
     * 运输任务费用
     */
    private Integer transportationTaskPrice;


    public Integer getTransportationTaskId() {
        return transportationTaskId;
    }

    public void setTransportationTaskId(Integer transportationTaskId) {
        this.transportationTaskId = transportationTaskId;
    }

    public Integer getTruckId() {
        return truckId;
    }

    public void setTruckId(Integer truckId) {
        this.truckId = truckId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getTransportationTaskGoodsNum() {
        return transportationTaskGoodsNum;
    }

    public void setTransportationTaskGoodsNum(Integer transportationTaskGoodsNum) {
        this.transportationTaskGoodsNum = transportationTaskGoodsNum;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getTransportationTaskDestination() {
        return transportationTaskDestination;
    }

    public void setTransportationTaskDestination(String transportationTaskDestination) {
        this.transportationTaskDestination = transportationTaskDestination;
    }

    public Date getTransportationTaskStartTime() {
        return transportationTaskStartTime;
    }

    public void setTransportationTaskStartTime(Date transportationTaskStartTime) {
        this.transportationTaskStartTime = transportationTaskStartTime;
    }

    public Date getTransportationTaskEndTime() {
        return transportationTaskEndTime;
    }

    public void setTransportationTaskEndTime(Date transportationTaskEndTime) {
        this.transportationTaskEndTime = transportationTaskEndTime;
    }

    public Integer getTransportationTaskPrice() {
        return transportationTaskPrice;
    }

    public void setTransportationTaskPrice(Integer transportationTaskPrice) {
        this.transportationTaskPrice = transportationTaskPrice;
    }

}

