package com.xws.oa.entity;

import java.util.Date;

public class BegBreak {
    private String begNo;

    private Integer begDay;

    private String begType;

    private String begReason;

    private Date begStart;

    private Date begEnd;

    private Boolean result;

    private String empNo;

    public String getBegNo() {
        return begNo;
    }

    public void setBegNo(String begNo) {
        this.begNo = begNo == null ? null : begNo.trim();
    }

    public Integer getBegDay() {
        return begDay;
    }

    public void setBegDay(Integer begDay) {
        this.begDay = begDay;
    }

    public String getBegType() {
        return begType;
    }

    public void setBegType(String begType) {
        this.begType = begType == null ? null : begType.trim();
    }

    public String getBegReason() {
        return begReason;
    }

    public void setBegReason(String begReason) {
        this.begReason = begReason == null ? null : begReason.trim();
    }

    public Date getBegStart() {
        return begStart;
    }

    public void setBegStart(Date begStart) {
        this.begStart = begStart;
    }

    public Date getBegEnd() {
        return begEnd;
    }

    public void setBegEnd(Date begEnd) {
        this.begEnd = begEnd;
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