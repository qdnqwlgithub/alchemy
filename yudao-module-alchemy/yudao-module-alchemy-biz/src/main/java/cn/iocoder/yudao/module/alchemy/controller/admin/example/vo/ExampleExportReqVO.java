package cn.iocoder.yudao.module.alchemy.controller.admin.example.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 案例 Excel 导出 Request VO，参数和 ExamplePageReqVO 是一致的")
@Data
public class ExampleExportReqVO {

    @Schema(description = "案例名称", example = "王五")
    private String name;

    @Schema(description = "所属分类", example = "2625")
    private Integer categoryId;

    @Schema(description = "封面图")
    private String avatar;

    @Schema(description = "轮播图地址")
    private String carousel;

    @Schema(description = "案例详情")
    private String content;

    @Schema(description = "显示顺序")
    private String sort;

    @Schema(description = "是否展示到首页")
    private String indexFlag;

    @Schema(description = "index排序")
    private String indexSort;

}
