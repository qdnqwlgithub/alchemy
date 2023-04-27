package cn.iocoder.yudao.module.alchemy.controller.admin.miniappconfig.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
* 小程序配置 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class MiniAppConfigBaseVO {

    @Schema(description = "小程序顶部logo", required = true)
    @NotNull(message = "小程序顶部logo不能为空")
    private String headImg;

    @Schema(description = "首页轮播", required = true)
    @NotNull(message = "首页轮播不能为空")
    private String carousel;

    @Schema(description = "index页面底部图片", required = true)
    @NotNull(message = "index页面底部图片不能为空")
    private String indexBottomImg;

    @Schema(description = "公司名", required = true, example = "张三")
    @NotNull(message = "公司名不能为空")
    private String companyName;

    @Schema(description = "轮播图地址", required = true)
    @NotNull(message = "轮播图地址不能为空")
    private String address;

    @Schema(description = "电话号码", required = true)
    @NotNull(message = "电话号码不能为空")
    private String phoneNumber;

    @Schema(description = "邮箱地址", required = true)
    @NotNull(message = "邮箱地址不能为空")
    private String email;

    @Schema(description = "地图坐标", required = true)
    @NotNull(message = "地图坐标不能为空")
    private String position;

    @Schema(description = "创建者")
    private String createBy;

    @Schema(description = "更新者")
    private String updateBy;

}
