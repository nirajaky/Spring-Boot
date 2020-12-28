package com.nirajaky.formValidation.entiries;

import javax.validation.constraints.*;

public class LoginData {
    @NotBlank(message = "Usename cannot be Null")
    @Size(min = 3, max = 12, message = "Size should be of 3-12 character")
    private String userName;

//    @Email
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid Email")
    private String email;
    @AssertTrue(message = "Must be checked")
    private boolean agreed;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LoginData() {
        super();
    }

    public LoginData(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public boolean isAgreed() {
        return agreed;
    }

    public void setAgreed(boolean agreed) {
        this.agreed = agreed;
    }

    @Override
    public String toString() {
        return "LoginData{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
