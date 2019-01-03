package com.xws.oa.entity;

public class Authorization {
    private String authorizationNo;

    private String authorizationName;

    public String getAuthorizationNo() {
        return authorizationNo;
    }

    public void setAuthorizationNo(String authorizationNo) {
        this.authorizationNo = authorizationNo == null ? null : authorizationNo.trim();
    }

    public String getAuthorizationName() {
        return authorizationName;
    }

    public void setAuthorizationName(String authorizationName) {
        this.authorizationName = authorizationName == null ? null : authorizationName.trim();
    }
}