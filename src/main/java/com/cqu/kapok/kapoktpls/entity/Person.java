package com.cqu.kapok.kapoktpls.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Person)实体类
 *
 * @author makejava
 * @since 2022-06-25 10:01:59
 */
public class Person implements Serializable {
    private static final long serialVersionUID = -49249821496978882L;
    /**
     * 主键ID
     */
    private Integer personId;
    /**
     * 姓名
     */
    private String personName;
    /**
     * 性别，0为女，1为男
     */
    private Integer personGender;
    /**
     * 出生日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date personBirth;
    /**
     * 移动电话号码
     */
    private String personNumber;
    /**
     * qq号码
     */
    private String personQq;
    /**
     * 居住地址
     */
    private String personAddress;
    /**
     * 公司id
     */
    private Integer companyId;
    /**
     * 员工银行账户
     */
    private String personBankAccount;


    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getPersonGender() {
        return personGender;
    }

    public void setPersonGender(Integer personGender) {
        this.personGender = personGender;
    }

    public Date getPersonBirth() {
        return personBirth;
    }

    public void setPersonBirth(Date personBirth) {
        this.personBirth = personBirth;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(String personNumber) {
        this.personNumber = personNumber;
    }

    public String getPersonQq() {
        return personQq;
    }

    public void setPersonQq(String personQq) {
        this.personQq = personQq;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getPersonBankAccount() {
        return personBankAccount;
    }

    public void setPersonBankAccount(String personBankAccount) {
        this.personBankAccount = personBankAccount;
    }

}

