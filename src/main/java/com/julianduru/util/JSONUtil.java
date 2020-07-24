package com.julianduru.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jayway.jsonpath.JsonPath;
import org.json.JSONObject;

import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * created by julian
 */
public class JSONUtil {

    static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }


    public static String asJsonString(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }


    public static String asJsonString(Object obj, String defaultString) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return defaultString;
        }
    }


    public static <T> T fromJsonString(String json, Class<T> klass) throws IOException {
        return objectMapper.readValue(json, klass);
    }


    public static JSONObject readObject(String json, String path) {
        return new JSONObject((LinkedHashMap) JsonPath.read(json, path));
    }


}
