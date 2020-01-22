create table if not exists `email_alarm`
(
    `id`           bigint(20)  not null auto_increment comment '主键',
    `gmt_create`   datetime(3) not null default current_timestamp(3) comment '创建时间',
    `gmt_modified` datetime(3) not null default CURRENT_TIMESTAMP(3) on update current_timestamp(3) comment '修改时间',
    `alarm_id`     bigint(20)  not null comment 'alarm表主键',
    `email`        bigint(20)  not null comment '英文逗号分隔的邮箱',
    primary key (`id`),
    index `idx_alarmid` (`alarm_id`)
) engine = InnoDB
  default charset = utf8mb4 comment ='邮件报警配置表';

