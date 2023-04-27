package cn.iocoder.yudao.module.alchemy.controller.admin.example.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
* 案例 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ExampleBaseVO {

    @Schema(description = "案例名称", required = true, example = "芋艿")
    @NotNull(message = "案例名称不能为空")
    private String name;

    @Schema(description = "所属分类", required = true, example = "29393")
    @NotNull(message = "所属分类不能为空")
    private Integer categoryId;

    @Schema(description = "封面图", required = true)
    @NotNull(message = "封面图不能为空")
    private String avatar;

    @Schema(description = "轮播图地址", required = true)
    @NotNull(message = "轮播图地址不能为空")
    private String carousel;

    @Schema(description = "案例详情", required = true)
    @NotNull(message = "案例详情不能为空")
    private String content;

    @Schema(description = "显示顺序", required = true)
    @NotNull(message = "显示顺序不能为空")
    private String sort;

    @Schema(description = "是否展示到首页", required = true)
    @NotNull(message = "是否展示到首页不能为空")
    private Boolean indexFlag;

    @Schema(description = "创建者")
    private String createBy;

    @Schema(description = "更新者")
    private String updateBy;

}
