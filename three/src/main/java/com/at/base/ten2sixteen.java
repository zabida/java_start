package com.at.base;

public class ten2sixteen {

    // 用于36进制的字符集合
    private static final char[] BASE36_CHARS = "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();

    // 将十进制转换为36进制
    public static String decimalToBase36(int decimal) {
        assert decimal < 36*36;
        if (decimal == 0) {
            return "00";
        }

        StringBuilder base36 = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 36;
            base36.insert(0, BASE36_CHARS[remainder]);
            decimal /= 36;
        }

        String string = base36.toString();
        if (string.length() <= 1) string = "0" + string;
        return string;
    }

    public static void main(String[] args) {
        int decimal = 1400;
        String base36 = decimalToBase36(decimal);
        System.out.println("Decimal: " + decimal);
        System.out.println("Base36: " + base36);
    }
}

