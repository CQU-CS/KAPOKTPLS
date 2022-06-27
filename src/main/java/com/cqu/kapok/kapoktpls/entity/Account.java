package com.cqu.kapok.kapoktpls.entity;

import com.cqu.kapok.kapoktpls.utils.result.code.Token;

import java.io.Serializable;

/**
 * (Account)实体类
 *
 * @author makejava
 * @since 2022-06-25 10:00:25
 */
public class Account implements Serializable {
    private static final long serialVersionUID = 154551467553808217L;
    /**
     * 主键id
     */
    private Integer accountId;
    /**
     * 账号
     */
    private String accountAccount;
    /**
     * 密码
     */
    private String accountPassword;
    /**
     * 头像地址
     */
    private String accountPicture;
    /**
     * 账号类型
     */
    private String accountType;
    /**
     * 账号昵称
     */
    private String accountNickname;
    /**
     * 账号对应的员工
     */
    private Integer personId;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountAccount() {
        return accountAccount;
    }

    public void setAccountAccount(String accountAccount) {
        this.accountAccount = accountAccount;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getAccountPicture() {
        return accountPicture;
    }

    public void setAccountPicture(String accountPicture) {
        this.accountPicture = accountPicture;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNickname() {
        return accountNickname;
    }

    public void setAccountNickname(String accountNickname) {
        this.accountNickname = accountNickname;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

}

