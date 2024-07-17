package com.at.tool.file;

import cn.hutool.json.JSONUtil;
import com.at.advance.Car;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;


@Slf4j
public class JsonWrite {
    public static void main(String[] args) {
        String outFileDir = Paths.get(System.getProperty("user.dir"), "recv").toString();
        File directory = new File(outFileDir);
        if (!directory.exists()) {
            boolean mkdirs = directory.mkdirs();// 如果目录不存在则创建
        }
        String outFile = Paths.get(outFileDir, "fileInfo.json").toString();
        String jsonStr = JSONUtil.toJsonStr(new Car());
        try {
            try (FileWriter fileWriter = new FileWriter(outFile, true)) {
                fileWriter.write(jsonStr + "\n");
            }
        }catch (IOException e){
            log.error("异常", e);
        }
    }
}
