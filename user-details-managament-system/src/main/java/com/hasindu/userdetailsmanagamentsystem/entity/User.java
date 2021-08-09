package com.hasindu.userdetailsmanagamentsystem.entity;

import com.sun.istack.NotNull;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Hasindu Dahanayake
 * Entitiy class for User
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    @NaturalId(mutable = true)
    @Column(name = "user_name", unique = true, length = 40)
    private String userName;
    @Column(name = "password")
    @NotNull
    private String password;
    @Column(name = "first_name")
    @NotNull
    private String firstName;
    @Column(name = "last_name")
    @NotNull
    private String lastName;
    @Column(name = "address")
    @NotNull
    private String address;
    @Column(name = "contact_number")
    @NotNull
    private String contactNumber;
    @Column(name = "gender")
    @NotNull
    private String gender;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_role_id")
    @NotNull
    private UserRole userRole;
    @Column(name = "company_code")
    @NotNull
    private String companyCode;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<LoginHistory> loginHistories;


    public User() {
    }

    public User(int userId, String userName, String password, String firstName, String lastName, String address, String contactNumber, String gender, UserRole userRole, String companyCode) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.gender = gender;
        this.userRole = userRole;
        this.companyCode = companyCode;
    }

    public User(String userName, String password, String firstName, String lastName, String address, String contactNumber, String gender, String companyCode) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.gender = gender;
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

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public void addLoginHistory(LoginHistory loginHistory) {
        if (this.loginHistories == null) {
            this.loginHistories = new ArrayList<>();
        }
        loginHistory.setUser(this);
        loginHistories.add(loginHistory);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userName.equals(user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", userRole=" + userRole.getRoleType() +
                ", companyCode='" + companyCode + '\'' +
                '}';
    }
}
