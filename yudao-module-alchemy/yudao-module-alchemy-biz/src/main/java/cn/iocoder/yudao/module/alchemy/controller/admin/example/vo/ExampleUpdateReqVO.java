package cn.iocoder.yudao.module.alchemy.controller.admin.example.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 案例更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExampleUpdateReqVO extends ExampleBaseVO {

    @Schema(description = "案例ID", required = true, example = "4970")
    @NotNull(message = "案例ID不能为空")
    private Long id;

}
