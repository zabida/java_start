package com.at.tool;

import java.util.regex.Pattern;

/**
 * <p>
 * </p>
 *
 * @author liqingshan
 * @since 2022/5/30 20:24
 */
public enum AESEncryptPatternEnum {

    MOBILE_PATTERN("^[1][0-9]{10}$"),
    EMAIL_PATTERN("^.+@[a-zA-Z0-9-]+\\..+$"),
    IDENTITY_PATTERN("^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$")
    ;

    private final String pattern;

    AESEncryptPatternEnum(String s) {
        this.pattern = s;
    }

    public String getPattern() {
        return pattern;
    }

    public static boolean isValidPattern(String content) {
        for (AESEncryptPatternEnum aesEncryptPatternEnum : AESEncryptPatternEnum.values()) {
            if (Pattern.compile(aesEncryptPatternEnum.getPattern()).matcher(content).matches()) {
                return true;
            }
        }
        return false;
    }
}
