package cn.iocoder.yudao.module.alchemy.controller.admin.miniappconfig.vo;

import cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str;
import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 小程序配置分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MiniAppConfigPageReqVO extends PageParam {

    @Schema(description = "小程序顶部logo")
    private I18Str headImg;

    @Schema(description = "轮播图地址")
    private I18Str carousel;

    @Schema(description = "index页面底部图片")
    private I18Str indexBottomImg;

    @Schema(description = "公司名", example = "赵六")
    private I18Str companyName;

    @Schema(description = "公司地址")
    private I18Str address;

    @Schema(description = "电话号码")
    private I18Str phoneNumber;

    @Schema(description = "邮箱地址")
    private I18Str email;

    @Schema(description = "地图坐标")
    private I18Str position;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
