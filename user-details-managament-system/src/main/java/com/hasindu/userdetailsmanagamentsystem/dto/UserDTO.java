package com.hasindu.userdetailsmanagamentsystem.dto;

import java.util.List;
/**
 * User DTO
 */
public class UserDTO {

    private int userId;

    private String userName;

    private String password;

    private String firstName;

    private String lastName;

    private String address;

    private String contactNumber;

    private String gender;

    private String userRoleType;

    private String companyCode;

    private List<LoginHistoryDTO> loginHistoryDTO;

    public UserDTO() {
    }


    public UserDTO(int userId, String userName, String password, String firstName, String lastName, String address, String contactNumber, String gender, String userRoleType, List<LoginHistoryDTO> loginHistoryDTO, String companyCode) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.gender = gender;
        this.userRoleType = userRoleType;
        this.loginHistoryDTO = loginHistoryDTO;
        this.companyCode = companyCode;
    }

    public UserDTO(int userId, String userName, String password, String firstName, String lastName, String address, String contactNumber, String gender, String userRoleType, String companyCode) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.gender = gender;
        this.userRoleType = userRoleType;
        this.companyCode = companyCode;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserRoleType() {
        return userRoleType;
    }

    public void setUserRoleType(String userRoleType) {
        this.userRoleType = userRoleType;
    }


    public List<LoginHistoryDTO> getLoginHistoryDTO() {
        return loginHistoryDTO;
    }

    public void setLoginHistoryDTO(List<LoginHistoryDTO> loginHistoryDTO) {
        this.loginHistoryDTO = loginHistoryDTO;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", userRoleType='" + userRoleType + '\'' +
                ", companyCode='" + companyCode + '\'' +
                '}';
    }
}
