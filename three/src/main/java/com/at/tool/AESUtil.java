package com.at.tool;

/**
 * <p>
 * </p>
 *
 * @author liqingshan
 * @since 2022/2/28 17:52
 */
import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.SecureUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;


@Slf4j
public class AESUtil {

    private static final byte[] KEY_BYTES;

    private static final String keyStr = "6056bf8ab54210500c71671a766b70df";

    static {
        KEY_BYTES = new byte[16];
        int i = 0;
        for (byte b : keyStr.getBytes()) {
            KEY_BYTES[i++ % 16] ^= b;
        }
    }

    public static String encrypt(String content) {
        if (StringUtils.isBlank(content)) {
            return content;
        }
        //防止二次加密
        String tmp = decrypt(content);
        if (!tmp.equals(content)) {
            return content;
        }

        try {
            return HexUtil.encodeHexStr(SecureUtil.aes(KEY_BYTES).encrypt(content), true);
        } catch (Exception e) {
            return content;
        }
    }

    public static String decrypt(String content) {
        if (StringUtils.isBlank(content)) {
            return content;
        }

        try {
            log.info("decrypt: " + content);
            return SecureUtil.aes(KEY_BYTES).decryptStr(content);
        } catch (Exception e) {
            log.info("decrypt error: " + e.getMessage());
            return content;
        }
    }

    public static void main(String[] args) {
        String msg = "19912340001";
        String encrypt = AESUtil.encrypt(msg);
        System.out.println(encrypt);

//        String encMsg = "ebcdd4699b4a27b4819b59a58a325be6";
//        String decrypt = AESUtil.decrypt(encMsg);
//        System.out.println(decrypt);
    }
}
