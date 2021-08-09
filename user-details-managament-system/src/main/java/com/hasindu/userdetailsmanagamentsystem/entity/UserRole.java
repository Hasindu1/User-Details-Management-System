package com.hasindu.userdetailsmanagamentsystem.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Hasindu Dahanayake
 * Entity class for UserRole
 */
@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;
    @Column(name = "role_type")
    private String roleType;

    public UserRole() {
    }


    public UserRole(String roleType) {
        this.roleType = roleType;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return roleId == userRole.roleId;
    }

    /*
     *Returning a constant value because of the usage of a generated value for equals method
     */
    @Override
    public int hashCode() {
        return 12;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "roleId=" + roleId +
                ", roleType='" + roleType + '\'' +
                '}';
    }
}
