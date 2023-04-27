package cn.iocoder.yudao.module.alchemy.controller.admin.miniappconfig.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 小程序配置更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MiniAppConfigUpdateReqVO extends MiniAppConfigBaseVO {

    @Schema(description = "小程序配置ID", required = true, example = "6568")
    @NotNull(message = "小程序配置ID不能为空")
    private Long id;

}
