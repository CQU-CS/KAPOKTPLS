package com.cqu.kapok.kapoktpls.entity;

import java.io.Serializable;

/**
 * (RepairRecord)实体类
 *
 * @author makejava
 * @since 2022-06-28 09:44:59
 */
public class RepairRecord implements Serializable {
    private static final long serialVersionUID = 245401360442424626L;
    /**
     * 维修记录ID
     */
    private Integer repairRecordId;
    /**
     * 维修汽车ID
     */
    private Integer truckRepairRecordId;
    /**
     * 维修人员ID
     */
    private Integer personId;


    public Integer getRepairRecordId() {
        return repairRecordId;
    }

    public void setRepairRecordId(Integer repairRecordId) {
        this.repairRecordId = repairRecordId;
    }

    public Integer getTruckRepairRecordId() {
        return truckRepairRecordId;
    }

    public void setTruckRepairRecordId(Integer truckRepairRecordId) {
        this.truckRepairRecordId = truckRepairRecordId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

}

