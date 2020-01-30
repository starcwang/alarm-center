package com.star.alarmcenter.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 报警中心的Web应用程序
 *
 * @author wangchao
 * @date 2020/01/20
 */
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = "com.star.alarmcenter")
public class AlarmCenterWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlarmCenterWebApplication.class, args);
    }

}
