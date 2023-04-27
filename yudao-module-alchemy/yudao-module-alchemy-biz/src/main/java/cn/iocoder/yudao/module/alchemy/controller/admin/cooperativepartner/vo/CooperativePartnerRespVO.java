package cn.iocoder.yudao.module.alchemy.controller.admin.cooperativepartner.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 合作伙伴 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CooperativePartnerRespVO extends CooperativePartnerBaseVO {

    @Schema(description = "合作伙伴ID", required = true, example = "25591")
    private Long id;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
