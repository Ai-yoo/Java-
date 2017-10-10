package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncodeMD5 {
    public static String EncodeByMD5(String string) {
        byte[] b = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(string.getBytes());
            b = md5.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return b.toString();
    }

}
