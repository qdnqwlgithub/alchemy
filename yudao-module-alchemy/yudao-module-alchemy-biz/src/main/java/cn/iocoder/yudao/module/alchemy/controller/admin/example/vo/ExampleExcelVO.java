package cn.iocoder.yudao.module.alchemy.controller.admin.example.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 案例 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class ExampleExcelVO {

    @ExcelProperty("案例ID")
    private Long id;

    @ExcelProperty("案例名称")
    private String name;

    @ExcelProperty("所属分类")
    private Integer categoryId;

    @ExcelProperty("封面图")
    private String avatar;

    @ExcelProperty("轮播图地址")
    private String carousel;

    @ExcelProperty("案例详情")
    private String content;

    @ExcelProperty("显示顺序")
    private String sort;

    @ExcelProperty("是否展示到首页")
    private String indexFlag;

    @ExcelProperty("index排序")
    private String indexSort;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
