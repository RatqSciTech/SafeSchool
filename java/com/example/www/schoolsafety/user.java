package com.example.www.schoolsafety;

public class user {
    private String email;
    private String password;

    private int isSuccess;
    private String message;

    public user(String email, String password, int isSuccess, String message) {
        this.email = email;
        this.password = password;
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(int isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
