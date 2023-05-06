package cn.iocoder.yudao.module.alchemy.controller.admin.cooperativepartner.vo;

import cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Lon;
import cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
* 合作伙伴 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class CooperativePartnerBaseVO {

    @Schema(description = "合作伙伴名称", required = true, example = "李四")
    @NotNull(message = "合作伙伴名称不能为空")
    private I18Str name;

    @Schema(description = "封面图", required = true)
    @NotNull(message = "封面图不能为空")
    private I18Str avatar;

    @Schema(description = "显示顺序", required = true)
    @NotNull(message = "显示顺序不能为空")
    private I18Lon sort;

}
