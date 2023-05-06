package cn.iocoder.yudao.module.alchemy.controller.admin.example.vo;

import cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Bool;
import cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Lon;
import cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str;
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

    @Schema(description = "案例名称", required = true, example = "王五")
    @NotNull(message = "案例名称不能为空")
    private I18Str name;

    @Schema(description = "所属分类", required = true, example = "2625")
    @NotNull(message = "所属分类不能为空")
    private Integer categoryId;

    @Schema(description = "封面图", required = true)
    @NotNull(message = "封面图不能为空")
    private I18Str avatar;

    @Schema(description = "轮播图地址", required = true)
    @NotNull(message = "轮播图地址不能为空")
    private I18Str carousel;

    @Schema(description = "案例详情", required = true)
    @NotNull(message = "案例详情不能为空")
    private I18Str content;

    @Schema(description = "显示顺序", required = true)
    @NotNull(message = "显示顺序不能为空")
    private I18Lon sort;

    @Schema(description = "是否展示到首页")
    private I18Bool indexFlag;

    @Schema(description = "index排序")
    private I18Lon indexSort;

}
