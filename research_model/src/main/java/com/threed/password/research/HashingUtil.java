package com.threed.password.research;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HashingUtil{
    private static final Logger logger = LoggerFactory.getLogger(HashingUtil.class);
 /**
     * Salt length is 128.
     */
    private static final int SALT_LENGTH = 128;

    private static final char B32_PLUS = new Base32().encodeToString(new byte[] { '+' }).charAt(0);
    private static final char B32_SLASH = new Base32().encodeToString(new byte[] { '/' }).charAt(0);

    private static final int ITERATIONS = 1000;
    private static final int KEY_LENGTH = 192;

 /**
     * Generates a salt for a client to hash the password. This should be stored with the client
     * password to reuse when validating the password.
     * 
     * @return A randomly generated salt
     */
    public static String generateSalt() {
        byte[] secretBytes = new byte[SALT_LENGTH];
        SecureRandom secRandomGen = new SecureRandom();
        secRandomGen.nextBytes(secretBytes);

        String baseSecret = Base64.encodeBase64String(secretBytes);
        // Replace + and / with base32 encoding
        baseSecret = baseSecret.replace('+', B32_PLUS).replace('/', B32_SLASH);

        // Only take the first SALT_LENGTH characters
        return baseSecret.substring(0, SALT_LENGTH);
    }

    /**
     * Hash the password using PBKDF2 with HmacSHA1.
     * 
     * @param password
     *            Password
     * @param salt
     *            Salt
     * @return Hashed password
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static String hashPassword(String password, String salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        char[] passwordChars = password.toCharArray();
        byte[] saltBytes = salt.getBytes();

        PBEKeySpec spec = new PBEKeySpec(passwordChars, saltBytes, ITERATIONS, KEY_LENGTH);
        SecretKeyFactory key = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hashedPassword = key.generateSecret(spec).getEncoded();
        return String.format("%x", new BigInteger(hashedPassword));
    }

    public static  Boolean validatePassword(String password, String salt, String storedPassword) {

        try {
            if (!storedPassword.equals(HashingUtil.hashPassword(password, salt))) {

                return false;
            }

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            logger.error("No Such Alogorithm exeption or Invalid Key Spec Exception");
            e.printStackTrace();
        }
        return true;
    }
}
