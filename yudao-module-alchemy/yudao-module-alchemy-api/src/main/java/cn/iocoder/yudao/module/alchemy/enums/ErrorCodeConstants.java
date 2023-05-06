package cn.iocoder.yudao.module.alchemy.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

public interface ErrorCodeConstants {

    ErrorCode CATEGORY_NOT_EXISTS = new ErrorCode(100, "分类不存在");
    ErrorCode CATEGORY_PARENT_NODE_EXCEPTION = new ErrorCode(-1, "分类的父节点不能是自己");


    ErrorCode ITEM_NOT_EXISTS = new ErrorCode(200, "元素不存在");
    ErrorCode EXAMPLE_NOT_EXISTS = new ErrorCode(300, "案例不存在");
    ErrorCode EXAMPLE_CATEGORY_NOT_EXISTS = new ErrorCode(400, "案例分类不存在");
    ErrorCode COOPERATIVE_PARTNER_NOT_EXISTS = new ErrorCode(500, "合作伙伴不存在");
    ErrorCode MINI_APP_CONFIG_NOT_EXISTS = new ErrorCode(600, "小程序配置不存在");



}
