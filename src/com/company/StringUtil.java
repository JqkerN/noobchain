package com.company;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class StringUtil {

    public static String applySha256(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            //Applies sha256 to our input,
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            // This will contain hash as hexadecimal
            StringBuffer hexString = new StringBuffer();
            // Converts byte Array -> hex String
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0'); // (keeping leading zeros)
                hexString.append(hex); // append the hex int
            }
            return hexString.toString(); // Convert to String for immutable properties.
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
