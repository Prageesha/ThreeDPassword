package com.threed.password.research;


import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Prageesha Hadunneththi
 */
public class TextPassword {

    private static final Logger logger = LoggerFactory.getLogger(TextPassword.class);

    private String userName;
    private String password;
    private String salt;


   

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }



    public String getSalt() {
        return salt;
    }


    public void setSalt() {

        String salt = HashingUtil.generateSalt();
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     *            password to set
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public void setPassword(String password) throws NoSuchAlgorithmException,
            InvalidKeySpecException {
        setSalt();
        password = HashingUtil.hashPassword(password, getSalt());
        this.password = password;
    }

   
}
