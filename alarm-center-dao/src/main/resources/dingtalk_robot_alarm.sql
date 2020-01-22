create table if not exists `dingtalk_robot_alarm`
(
    `id`           bigint(20)   not null auto_increment comment '主键',
    `gmt_create`   datetime(3)  not null default current_timestamp(3) comment '创建时间',
    `gmt_modified` datetime(3)  not null default CURRENT_TIMESTAMP(3) on update current_timestamp(3) comment '修改时间',
    `alarm_id`     bigint(20)   not null comment 'alarm表主键',
    `at_mobiles`   varchar(500) not null default '' comment '需要at的手机号，英文逗号分隔',
    `is_at_all`    tinyint(2)   not null default 0 comment '是否at全员',
    `keyword`      varchar(20)  not null default '' comment '自定义关键词',
    `signature`    varchar(100) not null default '' comment '签名',
    primary key (`id`),
    index `idx_alarmid` (`alarm_id`)
) engine = InnoDB
  default charset = utf8mb4 comment ='钉钉机器人报警配置表';

