package cn.iocoder.yudao.module.alchemy.controller.admin.miniappconfig.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 小程序配置 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class MiniAppConfigExcelVO {

    @ExcelProperty("小程序配置ID")
    private Long id;

    @ExcelProperty("小程序顶部logo")
    private String headImg;

    @ExcelProperty("轮播图地址")
    private String carousel;

    @ExcelProperty("index页面底部图片")
    private String indexBottomImg;

    @ExcelProperty("公司名")
    private String companyName;

    @ExcelProperty("公司地址")
    private String address;

    @ExcelProperty("电话号码")
    private String phoneNumber;

    @ExcelProperty("邮箱地址")
    private String email;

    @ExcelProperty("地图坐标")
    private String position;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
