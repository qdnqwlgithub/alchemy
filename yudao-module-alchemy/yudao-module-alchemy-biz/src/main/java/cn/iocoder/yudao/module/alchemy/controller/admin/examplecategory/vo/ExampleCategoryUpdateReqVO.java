package cn.iocoder.yudao.module.alchemy.controller.admin.examplecategory.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 案例分类更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExampleCategoryUpdateReqVO extends ExampleCategoryBaseVO {

    @Schema(description = "案例分类ID", required = true, example = "1158")
    @NotNull(message = "案例分类ID不能为空")
    private Long id;

}
