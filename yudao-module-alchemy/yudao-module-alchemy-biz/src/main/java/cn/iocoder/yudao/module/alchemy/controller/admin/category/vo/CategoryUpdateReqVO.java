package cn.iocoder.yudao.module.alchemy.controller.admin.category.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 分类更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CategoryUpdateReqVO extends CategoryBaseVO {

    @Schema(description = "分类id", required = true)
    @NotNull(message = "分类id不能为空")
    private Long id;

}
