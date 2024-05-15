package com.at.base;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class HexStringBytes {

    public static byte[] hexToBytes(String hex) {
        hex = hex.length() % 2 != 0 ? "0" + hex : hex;

        byte[] b = new byte[hex.length() / 2];
        for (int i = 0; i < b.length; i++) {
            int index = i * 2;
            int v = Integer.parseInt(hex.substring(index, index + 2), 16);
            b[i] = (byte) v;
        }
        return b;
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte aByte : bytes) {
            String hex = Integer.toHexString(aByte & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            builder.append(hex.toUpperCase());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String a = "看看aa";
        // 字符串转bytes转hexString
        String hexString = bytesToHex(a.getBytes());
        System.out.println("hexString: " + hexString);
        // hexString转bytes
        byte[] bytes = hexToBytes(hexString);
        // bytes转字符串
        String s = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(s);
    }
}
