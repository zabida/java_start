package com.at.tool;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;

public class FileUploadExample {

    public static void main(String[] args) {
        // 创建HttpClient实例
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

            // 指定上传文件的URL
            String uploadUrl = "https://uat2-api.chinadep.com/auth-api/attachment/upload"; //

            // 指定要上传的文件
            File file = new File("/C:/Users/WZE/Downloads/8cd6a9df4e3c401f8b7160826874979b.csv");

            // 创建MultipartEntityBuilder并添加文件
            HttpEntity fileEntity = MultipartEntityBuilder.create()
                    .addBinaryBody("file", file, ContentType.DEFAULT_BINARY, file.getName())
                    .build();

            // 创建HttpPost请求
            HttpPost httpPost = new HttpPost(uploadUrl);
            httpPost.setHeader("Authorization", "Bearer -TtlCSXTCZB5qS03T5UAW2QY5-A");
            httpPost.setHeader("Accept", "*/*");
            httpPost.setHeader("Content-Type", "");
            httpPost.setEntity(fileEntity);

            // 执行请求并获取响应
            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                // 打印响应状态
                System.out.println("Response Status: " + response.getStatusLine());
                // 打印响应内容
                String responseBody = EntityUtils.toString(response.getEntity());
                System.out.println("Response Body: " + responseBody);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
