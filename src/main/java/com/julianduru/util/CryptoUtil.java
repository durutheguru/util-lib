package com.julianduru.util;


import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * created by julian
 */
public class CryptoUtil {


    public static final String DEFAULT_HASH_ERROR_OUTPUT = "-";



    public static int hashBytes(String str) {
        return hashBytes(str.getBytes());
    }


    public static int hashBytes(byte[] bytes) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(bytes);
            return ByteBuffer.wrap(md.digest()).getInt();
        }
        catch (NoSuchAlgorithmException e) {
            return 0;
        }
    }


    public static String encryptString(String input) {
        try {
            var md = MessageDigest.getInstance("SHA-512");
            var bytes = md.digest(input.getBytes(StandardCharsets.UTF_8));

            var num = new BigInteger(1, bytes);
            var hashText = num.toString(16);

            while (hashText.length() < 32) {
                hashText = "0" + hashText;
            }

            return hashText;
        } catch (NoSuchAlgorithmException e) {
            return DEFAULT_HASH_ERROR_OUTPUT;
        }
    }


}


