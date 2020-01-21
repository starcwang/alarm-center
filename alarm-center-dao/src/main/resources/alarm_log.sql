create table if not exists `alarm_log`
(
    `id`               bigint(20)   not null auto_increment comment '主键',
    `gmt_create`       datetime(3)  not null default current_timestamp(3) comment '创建时间',
    `gmt_modified`     datetime(3)  not null default CURRENT_TIMESTAMP(3) on update current_timestamp(3) comment '修改时间',
    `code`             varchar(20)  not null default '' comment '编码',
    `group`            varchar(20)  not null default '' comment '组别',
    primary key (`id`),
    unique key `uk_group_code` (`group`, `code`),
    index `idx_code` (`code`)
) engine = InnoDB
  default charset = utf8mb4 comment ='报警日志记录表';
