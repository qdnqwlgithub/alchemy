package cn.iocoder.yudao.module.alchemy.controller.admin.category.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 分类 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CategoryRespVO extends CategoryBaseVO {

    @Schema(description = "分类id", required = true)
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}
