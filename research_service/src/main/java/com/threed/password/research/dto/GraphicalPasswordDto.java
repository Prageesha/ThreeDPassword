package com.threed.password.research.dto;


import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class GraphicalPasswordDto extends BaseDto{

    private String userName;
    private String password;

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }


    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }


}
