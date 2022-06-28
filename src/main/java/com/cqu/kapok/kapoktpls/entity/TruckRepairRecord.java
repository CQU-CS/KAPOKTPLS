package com.cqu.kapok.kapoktpls.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TruckRepairRecord)实体类
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
public class TruckRepairRecord implements Serializable {
    private static final long serialVersionUID = 235526548343592972L;
    /**
     * 车辆维修记录ID
     */
    private Integer truckRepairRecordId;
    /**
     * 汽车ID
     */
    private Integer truckId;
    /**
     * 维修开始时间
     */
    private Date truckRepairRecordStartTime;
    /**
     * 维修结束时间
     */
    private Date truckRepairRecordEndTime;


    public Integer getTruckRepairRecordId() {
        return truckRepairRecordId;
    }

    public void setTruckRepairRecordId(Integer truckRepairRecordId) {
        this.truckRepairRecordId = truckRepairRecordId;
    }

    public Integer getTruckId() {
        return truckId;
    }

    public void setTruckId(Integer truckId) {
        this.truckId = truckId;
    }

    public Date getTruckRepairRecordStartTime() {
        return truckRepairRecordStartTime;
    }

    public void setTruckRepairRecordStartTime(Date truckRepairRecordStartTime) {
        this.truckRepairRecordStartTime = truckRepairRecordStartTime;
    }

    public Date getTruckRepairRecordEndTime() {
        return truckRepairRecordEndTime;
    }

    public void setTruckRepairRecordEndTime(Date truckRepairRecordEndTime) {
        this.truckRepairRecordEndTime = truckRepairRecordEndTime;
    }

}

