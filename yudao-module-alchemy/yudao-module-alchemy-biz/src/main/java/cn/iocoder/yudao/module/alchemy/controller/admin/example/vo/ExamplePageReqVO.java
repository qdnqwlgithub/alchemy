package cn.iocoder.yudao.module.alchemy.controller.admin.example.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 案例分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExamplePageReqVO extends PageParam {

    @Schema(description = "案例名称", example = "芋艿")
    private String name;

    @Schema(description = "所属分类", example = "29393")
    private Integer categoryId;

    @Schema(description = "封面图")
    private String avatar;

    @Schema(description = "轮播图地址")
    private String carousel;

    @Schema(description = "案例详情")
    private String content;

    @Schema(description = "显示顺序")
    private String sort;

    @Schema(description = "是否展示到首页")
    private Boolean indexFlag;

    @Schema(description = "创建者")
    private String createBy;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "更新者")
    private String updateBy;

}
