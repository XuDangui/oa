package com.xws.oa.entity;

public class RoleKey {
    private String account;

    private String authorizationNo;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getAuthorizationNo() {
        return authorizationNo;
    }

    public void setAuthorizationNo(String authorizationNo) {
        this.authorizationNo = authorizationNo == null ? null : authorizationNo.trim();
    }
}