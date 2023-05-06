package cn.iocoder.yudao.module.alchemy.controller.admin.examplecategory.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 案例分类 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class ExampleCategoryExcelVO {

    @ExcelProperty("案例分类ID")
    private Long id;

    @ExcelProperty("案例分类名称")
    private String name;

    @ExcelProperty("显示顺序")
    private String sort;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
