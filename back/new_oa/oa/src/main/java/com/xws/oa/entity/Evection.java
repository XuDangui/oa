package com.xws.oa.entity;

import java.util.Date;

public class Evection {
    private String evectionNo;

    private Integer evectionDay;

    private String evectionVehicle;

    private String evectionReason;

    private Date evectionStart;

    private Date evectionEnd;

    private Boolean result;

    private String empNo;

    public String getEvectionNo() {
        return evectionNo;
    }

    public void setEvectionNo(String evectionNo) {
        this.evectionNo = evectionNo == null ? null : evectionNo.trim();
    }

    public Integer getEvectionDay() {
        return evectionDay;
    }

    public void setEvectionDay(Integer evectionDay) {
        this.evectionDay = evectionDay;
    }

    public String getEvectionVehicle() {
        return evectionVehicle;
    }

    public void setEvectionVehicle(String evectionVehicle) {
        this.evectionVehicle = evectionVehicle == null ? null : evectionVehicle.trim();
    }

    public String getEvectionReason() {
        return evectionReason;
    }

    public void setEvectionReason(String evectionReason) {
        this.evectionReason = evectionReason == null ? null : evectionReason.trim();
    }

    public Date getEvectionStart() {
        return evectionStart;
    }

    public void setEvectionStart(Date evectionStart) {
        this.evectionStart = evectionStart;
    }

    public Date getEvectionEnd() {
        return evectionEnd;
    }

    public void setEvectionEnd(Date evectionEnd) {
        this.evectionEnd = evectionEnd;
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