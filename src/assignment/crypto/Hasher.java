/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.crypto;

import java.security.*;
import java.util.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author Steven-
 */
public class Hasher {
    // override
    public static String hash(byte[] blockByte, String algo){
        String hash = null;
        try {
            byte[] hashBytes;
            MessageDigest md = MessageDigest.getInstance(algo);
            md.update(blockByte);
            hashBytes = md.digest();
            hash = String.valueOf(Hex.encodeHex(hashBytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hash;
    }

    public static String hash(String data, String algo) {
        String hash = null;
        try {
            byte[] hashBytes;
            MessageDigest md = MessageDigest.getInstance(algo);
            // fetch data in byte array
            md.update(data.getBytes());
            // generate hashBytes from MessageDigest
            hashBytes = md.digest();
            // Using base64, array to string
            //hash = Base64.getEncoder().encodeToString(hashBytes);
            hash = String.valueOf(Hex.encodeHex(hashBytes));
        } catch (NoSuchAlgorithmException e) {
        }
        return hash;
    }

    public static byte[] get(int bit){
        SecureRandom sr = new SecureRandom();
        byte[] b = new byte[bit];
        sr.nextBytes(b);
        return b;
    }
}
