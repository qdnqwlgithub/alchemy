package cn.iocoder.yudao.module.alchemy.controller.admin.category;

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

import cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.category.CategoryDO;
import cn.iocoder.yudao.module.alchemy.convert.category.CategoryConvert;
import cn.iocoder.yudao.module.alchemy.service.category.CategoryService;

@Tag(name = "管理后台 - 分类")
@RestController
@RequestMapping("/alchemy/category")
@Validated
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @PostMapping("/create")
    @Operation(summary = "创建分类")
    @PreAuthorize("@ss.hasPermission('alchemy:category:create')")
    public CommonResult<Long> createCategory(@Valid @RequestBody CategoryCreateReqVO createReqVO) {
        return success(categoryService.createCategory(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新分类")
    @PreAuthorize("@ss.hasPermission('alchemy:category:update')")
    public CommonResult<Boolean> updateCategory(@Valid @RequestBody CategoryUpdateReqVO updateReqVO) {
        categoryService.updateCategory(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除分类")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('alchemy:category:delete')")
    public CommonResult<Boolean> deleteCategory(@RequestParam("id") Long id) {
        categoryService.deleteCategory(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得分类")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('alchemy:category:query')")
    public CommonResult<CategoryRespVO> getCategory(@RequestParam("id") Long id) {
        CategoryDO category = categoryService.getCategory(id);
        return success(CategoryConvert.INSTANCE.convert(category));
    }

    @GetMapping("/list")
    @Operation(summary = "获得分类列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('alchemy:category:query')")
    public CommonResult<List<CategoryRespVO>> getCategoryList(@RequestParam("ids") Collection<Long> ids) {
        List<CategoryDO> list = categoryService.getCategoryList(ids);
        return success(CategoryConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得分类分页")
    @PreAuthorize("@ss.hasPermission('alchemy:category:query')")
    public CommonResult<PageResult<CategoryRespVO>> getCategoryPage(@Valid CategoryPageReqVO pageVO) {
        PageResult<CategoryDO> pageResult = categoryService.getCategoryPage(pageVO);
        return success(CategoryConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出分类 Excel")
    @PreAuthorize("@ss.hasPermission('alchemy:category:export')")
    @OperateLog(type = EXPORT)
    public void exportCategoryExcel(@Valid CategoryExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<CategoryDO> list = categoryService.getCategoryList(exportReqVO);
        // 导出 Excel
        List<CategoryExcelVO> datas = CategoryConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "分类.xls", "数据", CategoryExcelVO.class, datas);
    }

}
