package cn.iocoder.yudao.module.alchemy.controller.admin.item.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 元素分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ItemPageReqVO extends PageParam {

    @Schema(description = "元素名称", example = "张三")
    private String name;

    @Schema(description = "元素简介")
    private String intro;

    @Schema(description = "所属分类id", example = "28312")
    private Long categoryId;

    @Schema(description = "头像地址")
    private String avatar;

    @Schema(description = "轮播图地址")
    private String carousel;

    @Schema(description = "元素详情")
    private String content;

    @Schema(description = "产品手册")
    private String doc;

    @Schema(description = "浏览量")
    private Long viewNum;

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
