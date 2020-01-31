package com.star.alarmcenter;

import java.util.Map;

import javax.annotation.Resource;

import com.google.common.collect.Maps;
import com.star.alarmcenter.common.util.JsonUtil;
import com.star.alarmcenter.model.vos.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangchao
 * @date 2020/01/31
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest {

    @Resource
    private RestTemplate restTemplate;

    @Test
    public void testMain() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("code", "c1");
        System.out.println(JsonUtil.toJson(restTemplate.postForObject("http://localhost:9321/alarm/query?aaa=666", map, Result.class)));
    }
}
