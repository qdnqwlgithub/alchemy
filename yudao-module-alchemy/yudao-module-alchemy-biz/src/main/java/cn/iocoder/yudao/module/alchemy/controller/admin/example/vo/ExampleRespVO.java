package cn.iocoder.yudao.module.alchemy.controller.admin.example.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 案例 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExampleRespVO extends ExampleBaseVO {

    @Schema(description = "案例ID", required = true, example = "8462")
    private Long id;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
