package cn.iocoder.yudao.module.alchemy.controller.admin.item.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
* 元素 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ItemBaseVO {

    @Schema(description = "元素名称", required = true, example = "张三")
    @NotNull(message = "元素名称不能为空")
    private String name;

    @Schema(description = "元素简介", required = true)
    @NotNull(message = "元素简介不能为空")
    private String intro;

    @Schema(description = "所属分类id", required = true, example = "28312")
    @NotNull(message = "所属分类id不能为空")
    private Long cId;

    @Schema(description = "头像地址")
    private String avatar;

    @Schema(description = "轮播图地址")
    private String carousel;

    @Schema(description = "元素详情")
    private String content;

    @Schema(description = "产品手册")
    private String doc;

    @Schema(description = "浏览量", required = true)
    @NotNull(message = "浏览量不能为空")
    private Long viewNum;

    @Schema(description = "显示顺序", required = true)
    @NotNull(message = "显示顺序不能为空")
    private String sort;

    @Schema(description = "创建者")
    private String createBy;

    @Schema(description = "更新者")
    private String updateBy;

}
