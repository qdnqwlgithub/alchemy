package cn.iocoder.yudao.module.alchemy.controller.admin.miniappconfig;

import cn.iocoder.yudao.framework.common.util.collection.CollectionUtils;
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

import cn.iocoder.yudao.module.alchemy.controller.admin.miniappconfig.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.miniappconfig.MiniAppConfigDO;
import cn.iocoder.yudao.module.alchemy.convert.miniappconfig.MiniAppConfigConvert;
import cn.iocoder.yudao.module.alchemy.service.miniappconfig.MiniAppConfigService;

@Tag(name = "管理后台 - 小程序配置")
@RestController
@RequestMapping("/alchemy/mini-app-config")
@Validated
public class MiniAppConfigController {

    @Resource
    private MiniAppConfigService miniAppConfigService;

    @PostMapping("/create")
    @Operation(summary = "创建小程序配置")
    @PreAuthorize("@ss.hasPermission('alchemy:mini-app-config:create')")
    public CommonResult<Long> createMiniAppConfig(@Valid @RequestBody MiniAppConfigCreateReqVO createReqVO) {
        return success(miniAppConfigService.createMiniAppConfig(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新小程序配置")
    @PreAuthorize("@ss.hasPermission('alchemy:mini-app-config:update')")
    public CommonResult<Boolean> updateMiniAppConfig(@Valid @RequestBody MiniAppConfigUpdateReqVO updateReqVO) {
        miniAppConfigService.updateMiniAppConfig(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除小程序配置")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('alchemy:mini-app-config:delete')")
    public CommonResult<Boolean> deleteMiniAppConfig(@RequestParam("id") Long id) {
        miniAppConfigService.deleteMiniAppConfig(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得小程序配置")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('alchemy:mini-app-config:query')")
    public CommonResult<MiniAppConfigRespVO> getMiniAppConfig(@RequestParam("id") Long id) {
        MiniAppConfigDO miniAppConfig = miniAppConfigService.getMiniAppConfig(id);
        return success(MiniAppConfigConvert.INSTANCE.convert(miniAppConfig));
    }

    @GetMapping("/list")
    @Operation(summary = "获得小程序配置列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('alchemy:mini-app-config:query')")
    public CommonResult<List<MiniAppConfigRespVO>> getMiniAppConfigList(@RequestParam("ids") Collection<Long> ids) {
        List<MiniAppConfigDO> list = miniAppConfigService.getMiniAppConfigList(ids);
        return success(MiniAppConfigConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得小程序配置分页")
    @PreAuthorize("@ss.hasPermission('alchemy:mini-app-config:query')")
    public CommonResult<PageResult<MiniAppConfigRespVO>> getMiniAppConfigPage(@Valid MiniAppConfigPageReqVO pageVO) {
        PageResult<MiniAppConfigDO> pageResult = miniAppConfigService.getMiniAppConfigPage(pageVO);
        return success(MiniAppConfigConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出小程序配置 Excel")
    @PreAuthorize("@ss.hasPermission('alchemy:mini-app-config:export')")
    @OperateLog(type = EXPORT)
    public void exportMiniAppConfigExcel(@Valid MiniAppConfigExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MiniAppConfigDO> list = miniAppConfigService.getMiniAppConfigList(exportReqVO);
        // 导出 Excel
        List<MiniAppConfigExcelVO> datas = MiniAppConfigConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "小程序配置.xls", "数据", MiniAppConfigExcelVO.class, datas);
    }

}
