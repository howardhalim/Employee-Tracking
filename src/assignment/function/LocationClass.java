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
public class LocationClass implements Serializable {
    private String employeeId, gatewayId, detectedTime, scanTime, status;
    int duration;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
    }

    public String getDetectedTime() {
        return detectedTime;
    }

    public void setDetectedTime(String detectedTime) {
        this.detectedTime = detectedTime;
    }

    public String getScanTime() {
        return scanTime;
    }

    public void setScanTime(String scanTime) {
        this.scanTime = scanTime;
    }

    @Override
    public String toString() {
        return "Location{" + "employeeId=" + employeeId + ", gatewayId=" + 
                gatewayId + ", detectedTime=" + detectedTime + ", scanTime=" + 
                scanTime + '}';
    }
    
}
