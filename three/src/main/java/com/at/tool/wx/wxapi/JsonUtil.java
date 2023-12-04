package com.at.tool.wx.wxapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Component
public class JsonUtil {

    @Autowired
    private ObjectMapper objectMapper;

    public  String toJSON(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public  String prettyJSON(Object object) {
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public  <T> T toBean(String s, Class<T> clazz) {
        try {
            return objectMapper.readValue(s, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public  <T> List<T> toListBean(String s, Class<T> clazz) {
        try {
            return objectMapper.readValue(s, objectMapper.getTypeFactory().constructParametricType(ArrayList.class, clazz));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public  <T> Set<T> toSetBean(String s, Class<T> clazz) {
        try {
            return objectMapper.readValue(s, objectMapper.getTypeFactory().constructParametricType(TreeSet.class, clazz));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public JsonNode readTree(String json) {
        try {
            return objectMapper.readTree(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


}
