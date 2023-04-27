package cn.iocoder.yudao.module.alchemy.controller.admin.cooperativepartner.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 合作伙伴 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class CooperativePartnerExcelVO {

    @ExcelProperty("合作伙伴ID")
    private Long id;

    @ExcelProperty("合作伙伴名称")
    private String name;

    @ExcelProperty("封面图")
    private String avatar;

    @ExcelProperty("显示顺序")
    private String sort;

    @ExcelProperty("创建者")
    private String createBy;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("更新者")
    private String updateBy;

}
