package com.xenon.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class UUIDUtils
{
    public static String generateUniqueKey() {
        // 获取当前时间戳
        long timestamp = System.currentTimeMillis();

        // 生成UUID作为唯一标识符
        String uuid = UUID.randomUUID().toString();

        // 将时间戳和UUID连接起来作为唯一键
        String uniqueKey = timestamp + "-" + uuid;

        return uniqueKey;
    }

    public static String generateUniqueKeyMD5() {
        // 生成UUID作为唯一标识符
        String uuid = UUID.randomUUID().toString();

        try {
            // 创建MD5哈希函数实例
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 将UUID转换为字节数组
            byte[] uuidBytes = uuid.getBytes();

            // 计算MD5哈希值
            byte[] hashBytes = md.digest(uuidBytes);

            // 将哈希值转换为字符串
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
            }

            // 获取缩短后的键（可以根据需要截取一部分）
            String shortKey = sb.toString();

            return shortKey;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


        return null;
    }
}
