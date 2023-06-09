package cn.iocoder.yudao.module.alchemy.controller.admin.example.vo;

import cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Bool;
import cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Lon;
import cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str;
import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 案例分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExamplePageReqVO extends PageParam {

    @Schema(description = "案例名称", example = "王五")
    private I18Str name;

    @Schema(description = "所属分类", example = "2625")
    private Integer categoryId;

    @Schema(description = "封面图")
    private I18Str avatar;

    @Schema(description = "轮播图地址")
    private I18Str carousel;

    @Schema(description = "案例详情")
    private I18Str content;

    @Schema(description = "显示顺序")
    private I18Lon sort;

    @Schema(description = "是否展示到首页")
    private I18Bool indexFlag;

    @Schema(description = "index排序")
    private I18Str indexSort;

}
