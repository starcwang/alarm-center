create table if not exists `alert_log`
(
    `id`           bigint(20)   not null auto_increment comment '主键',
    `gmt_create`   datetime(3)  not null default current_timestamp(3) comment '创建时间',
    `gmt_modified` datetime(3)  not null default CURRENT_TIMESTAMP(3) on update current_timestamp(3) comment '修改时间',
    `alarm_id`     bigint(20)   not null comment 'alarm表主键',
    `locate`       varchar(500) not null default '' comment '位置',
    `message`      text comment '信息',
    `stack_trace`  text comment '堆栈信息',
    primary key (`id`),
    index `idx_alarmid` (`alarm_id`)
) engine = InnoDB
  default charset = utf8mb4 comment ='报警日志记录表';
