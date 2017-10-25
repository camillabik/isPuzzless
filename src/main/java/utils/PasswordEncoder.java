package utils;

import org.apache.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncoder {   private static final Logger logger = Logger.getLogger(PasswordEncoder.class);
    public static class PasswordEncoderException extends Exception {}

    public static String md5(String password) throws PasswordEncoderException {

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            logger.debug(e.getMessage());
            logger.error(e.getMessage());
            throw new PasswordEncoderException();
        }
        byte[] array = password.getBytes();
        byte[] array2 = md.digest(array);

        return new String(array2);

    }
    public static String encode(String password) throws PasswordEncoderException {

        String result = md5(password) + "sadasfdsa";

        StringBuilder a = new StringBuilder(result).reverse();
        result = a.toString();

        return result;

    }

}
