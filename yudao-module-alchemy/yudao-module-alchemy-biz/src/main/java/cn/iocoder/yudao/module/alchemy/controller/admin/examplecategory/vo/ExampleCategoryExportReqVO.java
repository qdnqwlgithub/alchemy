package cn.iocoder.yudao.module.alchemy.controller.admin.examplecategory.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 案例分类 Excel 导出 Request VO，参数和 ExampleCategoryPageReqVO 是一致的")
@Data
public class ExampleCategoryExportReqVO {

    @Schema(description = "案例分类名称", example = "张三")
    private String name;

    @Schema(description = "显示顺序")
    private String sort;

    @Schema(description = "创建者")
    private String createBy;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "更新者")
    private String updateBy;

}
