package com.joizhang.imooc.util;

import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import java.security.MessageDigest;

@Slf4j
public class SHAUtils {

    public static String getSHA1(@NotNull final String inStr) {
        return baseSHA(inStr, "SHA-1");
    }

    public static String getSHA256(@NotNull final String inStr) {
        return baseSHA(inStr, "SHA-256");
    }

    public static String getMD5(@NotNull final String inStr) {
        return baseSHA(inStr, "MD5");
    }

    private static String baseSHA(@NotNull final String inStr, @NotNull final String messageDigestInstance) {
        MessageDigest md;
        String outStr = null;
        try {
            md = MessageDigest.getInstance(messageDigestInstance);
            byte[] digest = md.digest(inStr.getBytes("UTF-8"));
            outStr = byteToString(digest);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return outStr;
    }

    private static String byteToString(@NotNull final byte[] digest) {
        StringBuilder str = new StringBuilder();
        String tempStr;
        for (byte aDigest : digest) {
            tempStr = (Integer.toHexString(aDigest & 0xff));
            if (tempStr.length() == 1) {
                str.append("0").append(tempStr);
            } else {
                str.append(tempStr);
            }
        }
        return str.toString().toLowerCase();
    }

}
