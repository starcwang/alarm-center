package com.star.alarmcenter.service.sender;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nonnull;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.star.alarmcenter.model.dos.AlarmDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @author wangchao
 * @date 2020/01/31
 */
@Slf4j
@Service
public class AlarmSenderService implements InitializingBean, ApplicationContextAware, DisposableBean {
    private ApplicationContext applicationContext;

    /** 报警发送方式所有实现 */
    private List<AlarmSender> alarmSenderList;

    /** 异步发送线程池 */
    private ExecutorService executorService;

    /**
     * 异步发送
     *
     * @param locate 定位
     * @param message 消息
     * @param stackTraceList 堆栈跟踪列表
     * @param alarm 报警
     */
    public void asyncSend(AlarmDO alarm, String locate, String message, List<String> stackTraceList) {
        alarmSenderList.forEach(alarmSender -> executorService.submit(() -> {
            try {
                alarmSender.send(alarm, locate, message, stackTraceList);
            } catch (Exception e) {
                log.error("发送消息异常", e);
            }
        }));
    }

    @Override
    public void afterPropertiesSet() {
        alarmSenderList = ImmutableList.copyOf(applicationContext.getBeansOfType(AlarmSender.class).values());
        // 初始化线程池
        executorService = new ThreadPoolExecutor(2, 10, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue<>(),
            new ThreadFactoryBuilder().setNameFormat("alarm-sender-%d").build(), new DiscardPolicy());
    }

    @Override
    public void setApplicationContext(@Nonnull ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void destroy() {
        if (executorService != null) {
            executorService.shutdown();
        }
    }
}
