package com.threed.password.research.dto;

public class TextPasswordDto extends BaseDto {

    private String userName;
    private String password;
    private String reEnteredPassword;
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

    public String getReEnteredPassword() {

        return reEnteredPassword;
    }

    public void setReEnteredPassword(String reEnteredPassword) {

        this.reEnteredPassword = reEnteredPassword;
    }


}
