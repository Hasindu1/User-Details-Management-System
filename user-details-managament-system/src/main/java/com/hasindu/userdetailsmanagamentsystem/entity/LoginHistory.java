package com.hasindu.userdetailsmanagamentsystem.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;
/**
 *Login History Entity
 */
@Entity
public class LoginHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private int recordId;
    @Column(name = "logged_in_date")
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date loggedInDate;
    @Column(name = "logged_in_time")
    @Temporal(TemporalType.TIME)
    @NotNull
    private Date loggedInTime;
    @Column(name = "ip_address")
    @NotNull
    private String ipAddress;
    @Column(name = "browser_name")
    private String browserName;
    @Column(name = "device_type")
    private String deviceType;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    public LoginHistory() {
    }


    public LoginHistory(Date loggedInDate, Date loggedInTime, String ipAddress, String browserName, String deviceType, User user) {
        this.loggedInDate = loggedInDate;
        this.loggedInTime = loggedInTime;
        this.ipAddress = ipAddress;
        this.browserName = browserName;
        this.deviceType = deviceType;
        this.user = user;
    }

    public LoginHistory(Date loggedInDate, Date loggedInTime, String ipAddress, String browserName, String deviceType) {
        this.loggedInDate = loggedInDate;
        this.loggedInTime = loggedInTime;
        this.ipAddress = ipAddress;
        this.browserName = browserName;
        this.deviceType = deviceType;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginHistory that = (LoginHistory) o;
        return recordId == that.recordId;
    }

    /*
     *Returning a constant value because of the usage of a generated value for equals method
     */
    @Override
    public int hashCode() {
        return 11;
    }

    @Override
    public String toString() {
        return "LoginHistory{" +
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