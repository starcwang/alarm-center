package com.star.alarmcenter.service.sender.impl;

import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.annotation.Resource;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.google.common.collect.Lists;
import com.star.alarmcenter.common.util.JsonUtil;
import com.star.alarmcenter.dao.DingtalkRobotAlarmDAO;
import com.star.alarmcenter.model.dos.AlarmDO;
import com.star.alarmcenter.model.dos.DingtalkRobotAlarmDO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangchao
 * @date 2020/01/31
 */
@Slf4j
@Component
public class DingtalkRobotAlarmSender extends AbstractAlarmSender<DingtalkRobotAlarmDAO, DingtalkRobotAlarmDO> {

    @Resource
    private RestTemplate restTemplate;

    @Override
    protected void doSend(AlarmDO alarm, DingtalkRobotAlarmDO dingtalkRobotAlarm, String locate, String message,
        List<String> stackTraceList) {

        String webhook = dingtalkRobotAlarm.getWebhook();
        if (StringUtils.isNotBlank(dingtalkRobotAlarm.getSecret())) {
            long timestamp = System.currentTimeMillis();
            String sign = buildSign(timestamp, dingtalkRobotAlarm.getSecret());
            if (webhook.contains("?")) {
                webhook += String.format("&timestamp=%s&sign=%s", timestamp, sign);
            } else {
                webhook += String.format("?timestamp=%s&sign=%s", timestamp, sign);
            }
        }

        DingtalkRobotAt at = new DingtalkRobotAt(Lists.newArrayList(StringUtils.split(dingtalkRobotAlarm.getAtMobiles(), ",")),
            BooleanUtils.toBooleanObject(dingtalkRobotAlarm.getIsAtAll()));
        String context = locate + " - " + message;
        if (StringUtils.isNotBlank(dingtalkRobotAlarm.getKeyword())) {
            context = dingtalkRobotAlarm.getKeyword() + " - " + context;
        }
        DingtalkRobotText text = new DingtalkRobotText(context);
        DingtalkRobotRequest request = new DingtalkRobotRequest();
        request.setText(text);
        request.setAt(at);

        DingtalkRobotResponse response = restTemplate.postForObject(webhook, request, DingtalkRobotResponse.class);
        if (response == null || response.getErrcode() != 0) {
            throw new RestClientException(String.format("请求异常:webhook=%s, request=%s, response=%s",
                webhook, JsonUtil.toJson(request), JsonUtil.toJson(response)));
        }
    }

    private String buildSign(long timestamp, String secret) {
        try {
            String stringToSign = timestamp + "\n" + secret;
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            byte[] signData = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
            return new String(Base64.encodeBase64(signData));
        } catch (Exception e) {
            log.error("生成签名失败", e);
            return StringUtils.EMPTY;
        }
    }

    @Getter
    @Setter
    @ToString
    private static class DingtalkRobotRequest {
        private String msgtype = "text";
        private DingtalkRobotText text;
        private DingtalkRobotAt at;
    }

    @Getter
    @Setter
    @ToString
    private static class DingtalkRobotResponse {
        private Integer errcode;
        private String errmsg;
    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    private static class DingtalkRobotText {
        private String content;
    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    private static class DingtalkRobotAt {
        private List<String> atMobiles;
        private boolean isAtAll;
    }
}
