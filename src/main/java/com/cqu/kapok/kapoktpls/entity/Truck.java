package com.cqu.kapok.kapoktpls.entity;

import java.io.Serializable;

/**
 * (Truck)实体类
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
public class Truck implements Serializable {
    private static final long serialVersionUID = -39252116214939205L;
    /**
     * 主键id
     */
    private Integer truckId;
    /**
     * 车牌
     */
    private String truckPlate;
    /**
     * 载重量，单位千克
     */
    private Integer truckLoad;
    /**
     * 车辆类型
     */
    private String truckType;
    /**
     * 驾驶员id
     */
    private Integer personId;


    public Integer getTruckId() {
        return truckId;
    }

    public void setTruckId(Integer truckId) {
        this.truckId = truckId;
    }

    public String getTruckPlate() {
        return truckPlate;
    }

    public void setTruckPlate(String truckPlate) {
        this.truckPlate = truckPlate;
    }

    public Integer getTruckLoad() {
        return truckLoad;
    }

    public void setTruckLoad(Integer truckLoad) {
        this.truckLoad = truckLoad;
    }

    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

}

