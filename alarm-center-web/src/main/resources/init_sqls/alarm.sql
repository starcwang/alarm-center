create table if not exists `alarm`
(
    `id`               bigint(20)   not null auto_increment comment '主键',
    `gmt_create`       datetime(3)  not null default current_timestamp(3) comment '创建时间',
    `gmt_modified`     datetime(3)  not null default CURRENT_TIMESTAMP(3) on update current_timestamp(3) comment '修改时间',
    `code`             varchar(20)  not null default '' comment '编码',
    `groups`           varchar(20)  not null default '' comment '组别',
    `name`             varchar(100) not null default '' comment '名称',
    `expression`       text comment '表达式',
    `status`           tinyint(4)   not null default 1 comment '状态',
    `description`      text comment '描述',
    `rule`             varchar(20)  not null default '' comment '规则',
    `interval_seconds` int(10)      not null default 30 comment '报警间隔秒数',
    primary key (`id`),
    unique key `uk_groups_code` (`groups`, `code`),
    index `idx_code` (`code`),
    index `idx_name` (`name`)
) engine = InnoDB
  default charset = utf8mb4 comment ='警报信息表';
