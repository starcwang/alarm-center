package com.star.alarmcenter.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @author wangchao
 * @date 2020/01/30
 */
public enum AlarmStatus {

    /** 关闭 */
    CLOSE(1, "关闭"),
    /** 开启 */
    OPEN(2, "开启"),
    ;

    @EnumValue
    private final int value;
    private final String desc;

    AlarmStatus(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 通过value获取枚举
     *
     * @param value 值
     * @return {@link AlarmStatus}
     */
    public static AlarmStatus fromValue(Integer value) {
        for (AlarmStatus alarmStatus : AlarmStatus.values()) {
            if (alarmStatus.value == value) {
                return alarmStatus;
            }
        }
        return null;
    }
}
