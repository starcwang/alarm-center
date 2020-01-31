package com.star.alarmcenter;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.junit.Test;

/**
 * @author wangchao
 * @date 2020/02/01
 */
public class CommonTest {

    @Test
    public void testMain() throws Exception {
        OkHttpClient.Builder mBuilder = new OkHttpClient.Builder();
        OkHttpClient client = mBuilder.build();

        RequestBody body = RequestBody.create(MediaType.get("application/json"), "{\"msgtype\":\"text\",\"text\":{\"content\":\"666 - 天津市 - 大家好\"},"
            + "\"at\":{\"atMobiles\":[],\"atAll\":true}}");
        Request request = new Request.Builder()
            .url("https://oapi.dingtalk.com/robot/send?access_token=7c4382507a32907899047fd3afb847bba20121dbff3abbd5f5747d1f426e75f4&timestamp=1580487011089&sign=ZExVoRTdvlzi4yQbB%2FyTYyV3%2B%2F%2Fj2YvldM9kvAyR6Oc%3D")
            .post(body)
            .build();
        client.newCall(request).execute();
    }
}
