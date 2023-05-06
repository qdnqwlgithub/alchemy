package cn.iocoder.yudao.module.alchemy.controller.admin.category.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 分类 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class CategoryExcelVO {

    @ExcelProperty("分类id")
    private Long id;

    @ExcelProperty("分类名称")
    private String name;

    @ExcelProperty("头像地址")
    private String avatar;

    @ExcelProperty("父分类id")
    private Long parentId;

    @ExcelProperty("浏览量")
    private String viewNum;

    @ExcelProperty("显示顺序")
    private String sort;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
