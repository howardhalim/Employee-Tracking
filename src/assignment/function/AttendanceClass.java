/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.function;

import java.io.Serializable;

/**
 *
 * @author Steven-
 */
public class AttendanceClass implements Serializable{
    String employeeId, checkIn, checkOut, shift, lateStatus, date;
    int workHours;
    boolean leaveStatus;

    public AttendanceClass(String employeeId, String checkIn, String checkOut, String shift, String lateStatus, String date, int workHours, boolean leaveStatus) {
        this.employeeId = employeeId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.shift = shift;
        this.lateStatus = lateStatus;
        this.date = date;
        this.workHours = workHours;
        this.leaveStatus = leaveStatus;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getLateStatus() {
        return lateStatus;
    }

    public void setLateStatus(String lateStatus) {
        this.lateStatus = lateStatus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public boolean isLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(boolean leaveStatus) {
        this.leaveStatus = leaveStatus;
    }
    
    
}
