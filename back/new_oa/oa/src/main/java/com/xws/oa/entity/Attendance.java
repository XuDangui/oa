package com.xws.oa.entity;

import java.util.Date;

public class Attendance {
    private String attendanceNo;

    private String attendanceState;

    private Date attendanceStart;

    private Date attendanceEnd;

    private String empNo;

    public String getAttendanceNo() {
        return attendanceNo;
    }

    public void setAttendanceNo(String attendanceNo) {
        this.attendanceNo = attendanceNo == null ? null : attendanceNo.trim();
    }

    public String getAttendanceState() {
        return attendanceState;
    }

    public void setAttendanceState(String attendanceState) {
        this.attendanceState = attendanceState == null ? null : attendanceState.trim();
    }

    public Date getAttendanceStart() {
        return attendanceStart;
    }

    public void setAttendanceStart(Date attendanceStart) {
        this.attendanceStart = attendanceStart;
    }

    public Date getAttendanceEnd() {
        return attendanceEnd;
    }

    public void setAttendanceEnd(Date attendanceEnd) {
        this.attendanceEnd = attendanceEnd;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo == null ? null : empNo.trim();
    }
}