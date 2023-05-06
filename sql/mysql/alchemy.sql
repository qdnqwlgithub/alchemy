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
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
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
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
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
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
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
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 20
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='案例表';