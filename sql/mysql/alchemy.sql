CREATE TABLE `alchemy_category`
(
    id          bigint auto_increment comment '分类id',
    `name`      json                                  not null comment '分类名称',
    `avatar`    json                                  not null NOT NULL COMMENT '头像地址',
    parent_id   json                                  not null NOT NULL comment '父分类id',
    `view_num`  bigint(20)                            NOT NULL DEFAULT '0' COMMENT '浏览量',
    sort        json                                  not null NOT NULL comment '显示顺序',
    creator     varchar(64) default ''                null comment '创建者',
    create_time datetime    default CURRENT_TIMESTAMP not null comment '创建时间',
    updater     varchar(64) default ''                null comment '更新者',
    update_time datetime    default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    deleted     bit         default b'0'              not null comment '是否删除',
    tenant_id   bigint      default 0                 not null comment '租户编号',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 139
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT = '分类表';

CREATE TABLE `alchemy_item`
(
    `id`          bigint(20)                                          NOT NULL AUTO_INCREMENT COMMENT '元素ID',
    `name`        json                                                not null NOT NULL COMMENT '元素名称',
    `intro`       json                                                not null NOT NULL COMMENT '元素简介',
    `c_id`        bigint(20)                                          NOT NULL COMMENT '所属分类id',
    `avatar`      json                                                not null NOT NULL COMMENT '头像地址',
    `carousel`    json                                                not null NOT NULL COMMENT '轮播图地址',
    `content`     json                                                not null NOT NULL COMMENT '元素详情',
    `doc`         json                                                not null NOT NULL COMMENT '产品手册',
    `view_num`    bigint(20)                                          NOT NULL DEFAULT '0' COMMENT '浏览量',
    sort          json                                                not null NOT NULL comment '显示顺序',
    `create_by`   varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime                               DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime                               DEFAULT NULL COMMENT '更新时间',
    deleted       bit                                    default b'0' not null comment '是否删除',
    `tenant_id`   bigint                                 default 0    not null comment '租户编号',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 54
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='元素表';


CREATE TABLE `alchemy_mini_app_config`
(
    `id`               bigint(20)                                          NOT NULL AUTO_INCREMENT COMMENT '小程序配置ID',
    `head_img`         json                                                not null NOT NULL COMMENT '小程序顶部logo',
    `carousel`    json                                                not null NOT NULL COMMENT '轮播图地址',
    `index_bottom_img` json                                                not null NOT NULL COMMENT 'index页面底部图片',
    `company_name`     json                                                not null NOT NULL COMMENT '公司名',
    `address`          json                                                not null NOT NULL COMMENT '公司地址',
    `phone_number`     json                                                not null NOT NULL COMMENT '电话号码',
    `email`            json                                                not null NOT NULL COMMENT '邮箱地址',
    `position`         json                                                not null NOT NULL COMMENT '地图坐标',
    `create_by`        varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time`      datetime                               DEFAULT NULL COMMENT '创建时间',
    `update_by`        varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time`      datetime                               DEFAULT NULL COMMENT '更新时间',
    deleted            bit                                    default b'0' not null comment '是否删除',
    `tenant_id`        bigint                                 default 0    not null comment '租户编号',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 54
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='小程序配置表';


CREATE TABLE `alchemy_cooperative_partner`
(
    `id`          bigint(20)                                       NOT NULL AUTO_INCREMENT COMMENT '合作伙伴ID',
    `name`        json                                             not NULL COMMENT '合作伙伴名称',
    `avatar`      json                                             not NULL COMMENT '封面图',
    `sort`        json                                             not null NOT NULL comment '显示顺序',
    `create_by`   varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime                               DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime                               DEFAULT NULL COMMENT '更新时间',
    `tenant_id`   bigint                                 default 0 not null comment '租户编号',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='合作伙伴表';

CREATE TABLE `alchemy_example_category`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '案例分类ID',
    `name`        json       NOT NULL COMMENT '案例分类名称',
    `sort`        json       not null NOT NULL comment '显示顺序',
    `create_by`   varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime                               DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime                               DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='案例分类表';

CREATE TABLE `alchemy_example`
(
    `id`          bigint(20)                                          NOT NULL AUTO_INCREMENT COMMENT '案例ID',
    `name`        json                                                not NULL COMMENT '案例名称',
    `category_id` int(11)                                             NOT NULL COMMENT '所属分类',
    `avatar`      json                                                not NULL COMMENT '封面图',
    `carousel`    json                                                not null NOT NULL COMMENT '轮播图地址',
    `content`     json                                                not NULL COMMENT '案例详情',
    `sort`        json                                                not null NOT NULL comment '显示顺序',
    `index_flag`  bit                                    default b'0' not null COMMENT '是否展示到首页',
    `create_by`   varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime                               DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime                               DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 20
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='案例表';