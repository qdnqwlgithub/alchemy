package cn.iocoder.yudao.module.alchemy.controller.admin.examplecategory.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
* 案例分类 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ExampleCategoryBaseVO {

    @Schema(description = "案例分类名称", required = true, example = "张三")
    @NotNull(message = "案例分类名称不能为空")
    private String name;

    @Schema(description = "显示顺序", required = true)
    @NotNull(message = "显示顺序不能为空")
    private String sort;

    @Schema(description = "创建者")
    private String createBy;

    @Schema(description = "更新者")
    private String updateBy;

}
