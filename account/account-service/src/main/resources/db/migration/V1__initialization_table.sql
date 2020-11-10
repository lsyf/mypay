create table account
(
    id          bigint unsigned auto_increment comment '账户id'
        primary key,
    currency    char(3)                                          not null comment '币种',
    amount      bigint              default 0                    not null comment '账户余额',
    frz_amount  bigint unsigned     default 0                    not null comment '冻结金额',
    avl_amount  bigint              default 0                    not null comment '可用金额',
    permission  char(5)             default '11111'              not null comment '权限(各个位置1-允许)：透支，冻结，只入金，只出金，转账。',
    create_time datetime(3)         default CURRENT_TIMESTAMP(3) not null,
    update_time datetime(3)         default CURRENT_TIMESTAMP(3) not null on update CURRENT_TIMESTAMP(3),
    is_locked   tinyint(1) unsigned default 0                    not null comment '是否锁定：1-是；0-否',
    is_active   tinyint(1) unsigned default 1                    not null comment '是否启用：1-是；0-否'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
    comment '账户表';

create table account_bill
(
    id             bigint unsigned auto_increment comment '流水id'
        primary key,
    account_id     bigint unsigned                          not null comment '账户id',
    type           varchar(3)                               not null comment '类型：in-入账；out-出账',
    currency       char(3)                                  not null comment '币种',
    amount         bigint      default 0                    not null comment '交易金额',
    last_amount    bigint      default 0                    not null comment '上期余额',
    current_amount bigint      default 0                    not null comment '当前余额',
    create_time    datetime(3) default CURRENT_TIMESTAMP(3) not null,
    biz_type       varchar(64)                              null comment '业务类型',
    biz_id         varchar(128)                             null comment '业务关联id',
    biz_info       varchar(1024)                            null comment '业务信息',
    remark         varchar(1024)                            null comment '备注',
    constraint uk_accountId_bizId_bizType
        unique (account_id, biz_id, biz_type)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
    comment '账户流水表';

create table account_freeze
(
    id          bigint unsigned auto_increment comment '冻结id'
        primary key,
    account_id  bigint unsigned                               not null comment '账户id',
    is_freeze   tinyint unsigned default 1                    not null comment '是否冻结：1-是；0-解冻',
    currency    char(3)                                       not null comment '币种',
    amount      bigint           default 0                    not null comment '冻结金额',
    create_time datetime(3)      default CURRENT_TIMESTAMP(3) not null,
    update_time datetime(3)      default CURRENT_TIMESTAMP(3) not null on update CURRENT_TIMESTAMP(3),
    biz_type    varchar(64)                                   null comment '业务类型',
    biz_id      varchar(128)                                  null comment '业务关联id',
    biz_info    varchar(1024)                                 null comment '业务信息',
    remark      varchar(1024)                                 null comment '备注',
    constraint uk_accountId_bizId_bizType
        unique (account_id, biz_id, biz_type)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
    comment '账户冻结单表';

