package cn.iocoder.yudao.module.alchemy.controller.admin.cooperativepartner;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.alchemy.controller.admin.cooperativepartner.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.cooperativepartner.CooperativePartnerDO;
import cn.iocoder.yudao.module.alchemy.convert.cooperativepartner.CooperativePartnerConvert;
import cn.iocoder.yudao.module.alchemy.service.cooperativepartner.CooperativePartnerService;

@Tag(name = "管理后台 - 合作伙伴")
@RestController
@RequestMapping("/alchemy/cooperative-partner")
@Validated
public class CooperativePartnerController {

    @Resource
    private CooperativePartnerService cooperativePartnerService;

    @PostMapping("/create")
    @Operation(summary = "创建合作伙伴")
    @PreAuthorize("@ss.hasPermission('alchemy:cooperative-partner:create')")
    public CommonResult<Long> createCooperativePartner(@Valid @RequestBody CooperativePartnerCreateReqVO createReqVO) {
        return success(cooperativePartnerService.createCooperativePartner(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新合作伙伴")
    @PreAuthorize("@ss.hasPermission('alchemy:cooperative-partner:update')")
    public CommonResult<Boolean> updateCooperativePartner(@Valid @RequestBody CooperativePartnerUpdateReqVO updateReqVO) {
        cooperativePartnerService.updateCooperativePartner(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除合作伙伴")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('alchemy:cooperative-partner:delete')")
    public CommonResult<Boolean> deleteCooperativePartner(@RequestParam("id") Long id) {
        cooperativePartnerService.deleteCooperativePartner(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得合作伙伴")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('alchemy:cooperative-partner:query')")
    public CommonResult<CooperativePartnerRespVO> getCooperativePartner(@RequestParam("id") Long id) {
        CooperativePartnerDO cooperativePartner = cooperativePartnerService.getCooperativePartner(id);
        return success(CooperativePartnerConvert.INSTANCE.convert(cooperativePartner));
    }

    @GetMapping("/list")
    @Operation(summary = "获得合作伙伴列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('alchemy:cooperative-partner:query')")
    public CommonResult<List<CooperativePartnerRespVO>> getCooperativePartnerList(@RequestParam("ids") Collection<Long> ids) {
        List<CooperativePartnerDO> list = cooperativePartnerService.getCooperativePartnerList(ids);
        return success(CooperativePartnerConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得合作伙伴分页")
    @PreAuthorize("@ss.hasPermission('alchemy:cooperative-partner:query')")
    public CommonResult<PageResult<CooperativePartnerRespVO>> getCooperativePartnerPage(@Valid CooperativePartnerPageReqVO pageVO) {
        PageResult<CooperativePartnerDO> pageResult = cooperativePartnerService.getCooperativePartnerPage(pageVO);
        return success(CooperativePartnerConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出合作伙伴 Excel")
    @PreAuthorize("@ss.hasPermission('alchemy:cooperative-partner:export')")
    @OperateLog(type = EXPORT)
    public void exportCooperativePartnerExcel(@Valid CooperativePartnerExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<CooperativePartnerDO> list = cooperativePartnerService.getCooperativePartnerList(exportReqVO);
        // 导出 Excel
        List<CooperativePartnerExcelVO> datas = CooperativePartnerConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "合作伙伴.xls", "数据", CooperativePartnerExcelVO.class, datas);
    }

}
