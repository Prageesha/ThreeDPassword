package com.threed.password.research.module.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Password {

    //  @JsonProperty("x")
    private int x;
    // @JsonProperty("y")
    private int y;

    public int getX() {

        return x;
    }

    public void setX(int x) {

        this.x = x;
    }

    public int getY() {

        return y;
    }

    public void setY(int y) {

        this.y = y;
    }



}
