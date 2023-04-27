package cn.iocoder.yudao.module.alchemy.controller.admin.miniappconfig.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 小程序配置创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MiniAppConfigCreateReqVO extends MiniAppConfigBaseVO {

}
