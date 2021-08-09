package com.hasindu.userdetailsmanagamentsystem.dto;

import java.util.Date;
/**
 *Login History DTO
 */
public class LoginHistoryDTO {
    private int recordId;

    private Date loggedInDate;

    private Date loggedInTime;

    private String ipAddress;

    private String browserName;

    private String deviceType;

    private UserDTO user;

    public LoginHistoryDTO() {
    }

    public LoginHistoryDTO(int recordId, Date loggedInDate, Date loggedInTime, String ipAddress, String browserName, String deviceType, UserDTO user) {
        this.recordId = recordId;
        this.loggedInDate = loggedInDate;
        this.loggedInTime = loggedInTime;
        this.ipAddress = ipAddress;
        this.browserName = browserName;
        this.deviceType = deviceType;
        this.user = user;
    }

    public LoginHistoryDTO(Date loggedInDate, Date loggedInTime, String ipAddress, String browserName, String deviceType, UserDTO user) {
        this.loggedInDate = loggedInDate;
        this.loggedInTime = loggedInTime;
        this.ipAddress = ipAddress;
        this.browserName = browserName;
        this.deviceType = deviceType;
        this.user = user;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public Date getLoggedInDate() {
        return loggedInDate;
    }

    public void setLoggedInDate(Date loggedInDate) {
        this.loggedInDate = loggedInDate;
    }

    public Date getLoggedInTime() {
        return loggedInTime;
    }

    public void setLoggedInTime(Date loggedInTime) {
        this.loggedInTime = loggedInTime;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LoginHistoryDTO{" +
                "recordId='" + recordId + '\'' +
                ", loggedInDate=" + loggedInDate +
                ", loggedInTime=" + loggedInTime +
                ", ipAddress='" + ipAddress + '\'' +
                ", browserName='" + browserName + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", user=" + user.getUserName() +
                '}';
    }
}
