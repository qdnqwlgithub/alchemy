package cn.iocoder.yudao.module.alchemy.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

public interface ErrorCodeConstants {

    ErrorCode CATEGORY_NOT_EXISTS = new ErrorCode(100, "分类不存在");
    ErrorCode ITEM_NOT_EXISTS = new ErrorCode(200, "元素不存在");



}
