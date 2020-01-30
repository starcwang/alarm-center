package com.star.alarmcenter.common.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author wangchao
 * @date 2020/01/28
 */
@Slf4j
public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();
    static {
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    private JsonUtil() {}

    public static <T> String toJson(T obj) {
        if (Objects.isNull(obj)) {
            return "";
        }
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.warn("json序列化异常", e);
            return "";
        }
    }

    public static <T> T fromJson(String json, Class<T> tClass) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            return objectMapper.readValue(json, tClass);
        } catch (IOException e) {
            log.warn("json序列化异常,json=" + json, e);
            return null;
        }
    }

    public static <T> T fromJson(String json, TypeReference<T> tTypeReference) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            return objectMapper.readValue(json, tTypeReference);
        } catch (IOException e) {
            log.warn("json序列化异常,json=" + json, e);
            return null;
        }
    }

}
