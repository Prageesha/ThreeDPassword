package com.threed.password.research;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class ThreeDPassword {


    private String userName;
    private String password;
    private String salt;


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

        try {
            setSalt();
            password = HashingUtil.hashPassword(password, getSalt());
            this.password = password;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

    }


    public String getSalt() {
        return salt;
    }


    public void setSalt() {

        String salt = HashingUtil.generateSalt();
        this.salt = salt;


    }
}
