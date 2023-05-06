package cn.iocoder.yudao.module.alchemy.controller.admin.category.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.*;

/**
* 分类 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class CategoryBaseVO {

    @Schema(description = "分类名称")
    private I18Str name;

    @Schema(description = "头像地址")
    private I18Str avatar;

    @Schema(description = "父分类id")
    private Long parentId;

    @Schema(description = "浏览量", required = true)
    @NotNull(message = "浏览量不能为空")
    private I18Lon viewNum;

    @Schema(description = "显示顺序")
    private I18Lon sort;

}
