package cn.iocoder.yudao.module.alchemy.controller.admin.category.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 分类 Excel 导出 Request VO，参数和 CategoryPageReqVO 是一致的")
@Data
public class CategoryExportReqVO {

    @Schema(description = "分类名称")
    private String name;

    @Schema(description = "头像地址")
    private String avatar;

    @Schema(description = "父分类id")
    private Long parentId;

    @Schema(description = "浏览量")
    private String viewNum;

    @Schema(description = "显示顺序")
    private String sort;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
