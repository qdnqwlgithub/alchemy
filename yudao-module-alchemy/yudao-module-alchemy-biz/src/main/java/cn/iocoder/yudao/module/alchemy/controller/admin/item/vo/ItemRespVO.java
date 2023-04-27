package cn.iocoder.yudao.module.alchemy.controller.admin.item.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 元素 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ItemRespVO extends ItemBaseVO {

    @Schema(description = "元素ID", required = true, example = "6235")
    private Long id;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
