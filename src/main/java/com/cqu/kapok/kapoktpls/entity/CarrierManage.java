package com.cqu.kapok.kapoktpls.entity;

import java.io.Serializable;

/**
 * (CarrierManage)实体类
 *
 * @author makejava
 * @since 2022-06-28 10:46:00
 */
public class CarrierManage implements Serializable {
    private static final long serialVersionUID = -83837749752671025L;
    /**
     * 承运商管理ID
     */
    private Integer carrierManageId;
    /**
     * 运输任务ID
     */
    private Integer transportationTaskId;
    /**
     * 承运商ID
     */
    private Integer carrierId;
    /**
     * 费用
     */
    private Integer carrierManagePrice;
    /**
     * 付款状态
     */
    private Integer payStatus;


    public Integer getCarrierManageId() {
        return carrierManageId;
    }

    public void setCarrierManageId(Integer carrierManageId) {
        this.carrierManageId = carrierManageId;
    }

    public Integer getTransportationTaskId() {
        return transportationTaskId;
    }

    public void setTransportationTaskId(Integer transportationTaskId) {
        this.transportationTaskId = transportationTaskId;
    }

    public Integer getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }

    public Integer getCarrierManagePrice() {
        return carrierManagePrice;
    }

    public void setCarrierManagePrice(Integer carrierManagePrice) {
        this.carrierManagePrice = carrierManagePrice;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

}

