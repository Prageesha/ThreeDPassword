package com.threed.password.research.module.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TextPasswordRegistrationRequest {
    @JsonProperty(value = "userName", required = true)
    private String userName;

    @JsonProperty(value = "password", required = true)
    private String password;


    @JsonProperty(value = "reEnterPassword", required = true)
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

    public void setReEnteredPassword(String  reEnteredPassword) {

        this.reEnteredPassword = reEnteredPassword;
    }

}
