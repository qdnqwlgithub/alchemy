package cn.iocoder.yudao.module.alchemy.controller.admin.cooperativepartner.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 合作伙伴更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CooperativePartnerUpdateReqVO extends CooperativePartnerBaseVO {

    @Schema(description = "合作伙伴ID", required = true, example = "2414")
    @NotNull(message = "合作伙伴ID不能为空")
    private Long id;

}
