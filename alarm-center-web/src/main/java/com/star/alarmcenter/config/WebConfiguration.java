package com.star.alarmcenter.config;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangchao
 * @date 2020/01/31
 */
@Configuration
public class WebConfiguration {

    @Bean
    public RestTemplate getRestTemplate(ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(3, TimeUnit.SECONDS);
        builder.readTimeout(3, TimeUnit.SECONDS);
        return new OkHttp3ClientHttpRequestFactory(builder.build());
    }
}
