package com.hasindu.userdetailsmanagamentsystem.dto;
/**
 *User Role DTO
 */
public class UserRoleDTO {

    private int roleId;

    private String roleType;

    public UserRoleDTO() {
    }

    public UserRoleDTO(int roleId, String roleType) {
        this.roleId = roleId;
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
    public String toString() {
        return "UserRoleDTO{" +
                "roleId=" + roleId +
                ", roleType='" + roleType + '\'' +
                '}';
    }
}
