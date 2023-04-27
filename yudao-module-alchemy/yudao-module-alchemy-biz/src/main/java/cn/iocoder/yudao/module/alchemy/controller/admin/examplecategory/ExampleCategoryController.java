package cn.iocoder.yudao.module.alchemy.controller.admin.examplecategory;

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

import cn.iocoder.yudao.module.alchemy.controller.admin.examplecategory.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.examplecategory.ExampleCategoryDO;
import cn.iocoder.yudao.module.alchemy.convert.examplecategory.ExampleCategoryConvert;
import cn.iocoder.yudao.module.alchemy.service.examplecategory.ExampleCategoryService;

@Tag(name = "管理后台 - 案例分类")
@RestController
@RequestMapping("/alchemy/example-category")
@Validated
public class ExampleCategoryController {

    @Resource
    private ExampleCategoryService exampleCategoryService;

    @PostMapping("/create")
    @Operation(summary = "创建案例分类")
    @PreAuthorize("@ss.hasPermission('alchemy:example-category:create')")
    public CommonResult<Long> createExampleCategory(@Valid @RequestBody ExampleCategoryCreateReqVO createReqVO) {
        return success(exampleCategoryService.createExampleCategory(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新案例分类")
    @PreAuthorize("@ss.hasPermission('alchemy:example-category:update')")
    public CommonResult<Boolean> updateExampleCategory(@Valid @RequestBody ExampleCategoryUpdateReqVO updateReqVO) {
        exampleCategoryService.updateExampleCategory(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除案例分类")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('alchemy:example-category:delete')")
    public CommonResult<Boolean> deleteExampleCategory(@RequestParam("id") Long id) {
        exampleCategoryService.deleteExampleCategory(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得案例分类")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('alchemy:example-category:query')")
    public CommonResult<ExampleCategoryRespVO> getExampleCategory(@RequestParam("id") Long id) {
        ExampleCategoryDO exampleCategory = exampleCategoryService.getExampleCategory(id);
        return success(ExampleCategoryConvert.INSTANCE.convert(exampleCategory));
    }

    @GetMapping("/list")
    @Operation(summary = "获得案例分类列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('alchemy:example-category:query')")
    public CommonResult<List<ExampleCategoryRespVO>> getExampleCategoryList(@RequestParam("ids") Collection<Long> ids) {
        List<ExampleCategoryDO> list = exampleCategoryService.getExampleCategoryList(ids);
        return success(ExampleCategoryConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得案例分类分页")
    @PreAuthorize("@ss.hasPermission('alchemy:example-category:query')")
    public CommonResult<PageResult<ExampleCategoryRespVO>> getExampleCategoryPage(@Valid ExampleCategoryPageReqVO pageVO) {
        PageResult<ExampleCategoryDO> pageResult = exampleCategoryService.getExampleCategoryPage(pageVO);
        return success(ExampleCategoryConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出案例分类 Excel")
    @PreAuthorize("@ss.hasPermission('alchemy:example-category:export')")
    @OperateLog(type = EXPORT)
    public void exportExampleCategoryExcel(@Valid ExampleCategoryExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ExampleCategoryDO> list = exampleCategoryService.getExampleCategoryList(exportReqVO);
        // 导出 Excel
        List<ExampleCategoryExcelVO> datas = ExampleCategoryConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "案例分类.xls", "数据", ExampleCategoryExcelVO.class, datas);
    }

}
