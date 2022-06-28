package com.cqu.kapok.kapoktpls.entity;

import java.io.Serializable;

/**
 * (Token)实体类
 *
 * @author makejava
 * @since 2022-06-27 16:30:59
 */
public class Token implements Serializable {
    private static final long serialVersionUID = 580710814694239498L;
    /**
     * token值
     */
    private String tokenValue;
    /**
     * account主键
     */
    private Integer accountId;


    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

}

