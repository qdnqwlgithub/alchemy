package cn.iocoder.yudao.module.alchemy.controller.admin.miniappconfig.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 小程序配置 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MiniAppConfigRespVO extends MiniAppConfigBaseVO {

    @Schema(description = "小程序配置ID", required = true, example = "6568")
    private Long id;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
