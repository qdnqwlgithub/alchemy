package cn.iocoder.yudao.module.alchemy.controller.admin.examplecategory.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 案例分类 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExampleCategoryRespVO extends ExampleCategoryBaseVO {

    @Schema(description = "案例分类ID", required = true, example = "1158")
    private Long id;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
