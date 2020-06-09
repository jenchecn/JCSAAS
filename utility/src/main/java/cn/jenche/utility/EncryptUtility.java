package cn.jenche.utility;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/6/9 10:22
 * @Description: 加密工具
 */
public class EncryptUtility {
    /**
     * 使用Apache的codec加密，使用SHA算法<br>
     * 注意：返回值为小写字符，请比较时注意
     *
     * @param text      待加密的字符串
     * @param algorithm 加密算法 SHA-1,SHA-256,SHA-384,SHA-512
     * @return 加密后的字符串{@link String}
     */
    public static String getSha(String text, String algorithm) {
        if (text == null) {
            return null;
        }
        if (null == algorithm) {
            return DigestUtils.sha1Hex(text);
        }

        switch (algorithm) {
            case "SHA-1":
                return DigestUtils.sha1Hex(text);
            case "SHA-256":
                return DigestUtils.sha256Hex(text);
            case "SHA-384":
                return DigestUtils.sha384Hex(text);
            case "SHA-512":
                return DigestUtils.sha512Hex(text);
            default:
                return null;
        }
    }
}
