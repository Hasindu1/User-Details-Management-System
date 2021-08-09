package com.hasindu.userdetailsmanagamentsystem.dto;
/**
 *Login status response DTO
 */
public class LoginResponseDTO {
    private String message;

    public LoginResponseDTO() {

    }

    public LoginResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LoginResponseDTO{" +
                "message='" + message + '\'' +
                '}';
    }
}
