package cn.iocoder.yudao.module.alchemy.controller.admin.example;

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

import cn.iocoder.yudao.module.alchemy.controller.admin.example.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.example.ExampleDO;
import cn.iocoder.yudao.module.alchemy.convert.example.ExampleConvert;
import cn.iocoder.yudao.module.alchemy.service.example.ExampleService;

@Tag(name = "管理后台 - 案例")
@RestController
@RequestMapping("/alchemy/example")
@Validated
public class ExampleController {

    @Resource
    private ExampleService exampleService;

    @PostMapping("/create")
    @Operation(summary = "创建案例")
    @PreAuthorize("@ss.hasPermission('alchemy:example:create')")
    public CommonResult<Long> createExample(@Valid @RequestBody ExampleCreateReqVO createReqVO) {
        return success(exampleService.createExample(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新案例")
    @PreAuthorize("@ss.hasPermission('alchemy:example:update')")
    public CommonResult<Boolean> updateExample(@Valid @RequestBody ExampleUpdateReqVO updateReqVO) {
        exampleService.updateExample(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除案例")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('alchemy:example:delete')")
    public CommonResult<Boolean> deleteExample(@RequestParam("id") Long id) {
        exampleService.deleteExample(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得案例")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('alchemy:example:query')")
    public CommonResult<ExampleRespVO> getExample(@RequestParam("id") Long id) {
        ExampleDO example = exampleService.getExample(id);
        return success(ExampleConvert.INSTANCE.convert(example));
    }

    @GetMapping("/list")
    @Operation(summary = "获得案例列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('alchemy:example:query')")
    public CommonResult<List<ExampleRespVO>> getExampleList(@RequestParam("ids") Collection<Long> ids) {
        List<ExampleDO> list = exampleService.getExampleList(ids);
        return success(ExampleConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得案例分页")
    @PreAuthorize("@ss.hasPermission('alchemy:example:query')")
    public CommonResult<PageResult<ExampleRespVO>> getExamplePage(@Valid ExamplePageReqVO pageVO) {
        PageResult<ExampleDO> pageResult = exampleService.getExamplePage(pageVO);
        return success(ExampleConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出案例 Excel")
    @PreAuthorize("@ss.hasPermission('alchemy:example:export')")
    @OperateLog(type = EXPORT)
    public void exportExampleExcel(@Valid ExampleExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ExampleDO> list = exampleService.getExampleList(exportReqVO);
        // 导出 Excel
        List<ExampleExcelVO> datas = ExampleConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "案例.xls", "数据", ExampleExcelVO.class, datas);
    }

}
