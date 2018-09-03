package com.threed.password.research.module.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.List;

public class GraphicalPasswordRequest {

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public List<Password> getPassword() {

        return password;
    }

    public void setPassword(List<Password> password) {

        this.password = password;
    }

    @JsonProperty(value = "userName", required = true)
    private String userName;

    @JsonProperty(value="password", required = true)
    //private String password;
   private List<Password> password;

}
