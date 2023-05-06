package cn.iocoder.yudao.module.alchemy.controller.admin.item.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 元素 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class ItemExcelVO {

    @ExcelProperty("元素ID")
    private Long id;

    @ExcelProperty("元素名称")
    private String name;

    @ExcelProperty("元素简介")
    private String intro;

    @ExcelProperty("所属分类id")
    private Long categoryId;

    @ExcelProperty("头像地址")
    private String avatar;

    @ExcelProperty("轮播图地址")
    private String carousel;

    @ExcelProperty("元素详情")
    private String content;

    @ExcelProperty("产品手册")
    private String doc;

    @ExcelProperty("浏览量")
    private Long viewNum;

    @ExcelProperty("显示顺序")
    private String sort;

    @ExcelProperty("创建者")
    private String createBy;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("更新者")
    private String updateBy;

}
