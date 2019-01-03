package com.xws.oa.entity;

import java.util.Date;

public class WorkOvertime {
    private String overNo;

    private String overReason;

    private Date overStart;

    private Date overEnd;

    private Boolean result;

    private String empNo;

    public String getOverNo() {
        return overNo;
    }

    public void setOverNo(String overNo) {
        this.overNo = overNo == null ? null : overNo.trim();
    }

    public String getOverReason() {
        return overReason;
    }

    public void setOverReason(String overReason) {
        this.overReason = overReason == null ? null : overReason.trim();
    }

    public Date getOverStart() {
        return overStart;
    }

    public void setOverStart(Date overStart) {
        this.overStart = overStart;
    }

    public Date getOverEnd() {
        return overEnd;
    }

    public void setOverEnd(Date overEnd) {
        this.overEnd = overEnd;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo == null ? null : empNo.trim();
    }
}