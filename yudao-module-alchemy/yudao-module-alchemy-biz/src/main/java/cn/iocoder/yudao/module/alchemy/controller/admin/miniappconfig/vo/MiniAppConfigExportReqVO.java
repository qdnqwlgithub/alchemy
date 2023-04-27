package cn.iocoder.yudao.module.alchemy.controller.admin.miniappconfig.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 小程序配置 Excel 导出 Request VO，参数和 MiniAppConfigPageReqVO 是一致的")
@Data
public class MiniAppConfigExportReqVO {

    @Schema(description = "小程序顶部logo")
    private String headImg;

    @Schema(description = "首页轮播")
    private String carousel;

    @Schema(description = "index页面底部图片")
    private String indexBottomImg;

    @Schema(description = "公司名", example = "张三")
    private String companyName;

    @Schema(description = "轮播图地址")
    private String address;

    @Schema(description = "电话号码")
    private String phoneNumber;

    @Schema(description = "邮箱地址")
    private String email;

    @Schema(description = "地图坐标")
    private String position;

    @Schema(description = "创建者")
    private String createBy;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "更新者")
    private String updateBy;

}
