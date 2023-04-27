package cn.iocoder.yudao.module.alchemy.controller.admin.item;

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

import cn.iocoder.yudao.module.alchemy.controller.admin.item.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.item.ItemDO;
import cn.iocoder.yudao.module.alchemy.convert.item.ItemConvert;
import cn.iocoder.yudao.module.alchemy.service.item.ItemService;

@Tag(name = "管理后台 - 元素")
@RestController
@RequestMapping("/alchemy/item")
@Validated
public class ItemController {

    @Resource
    private ItemService itemService;

    @PostMapping("/create")
    @Operation(summary = "创建元素")
    @PreAuthorize("@ss.hasPermission('alchemy:item:create')")
    public CommonResult<Long> createItem(@Valid @RequestBody ItemCreateReqVO createReqVO) {
        return success(itemService.createItem(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新元素")
    @PreAuthorize("@ss.hasPermission('alchemy:item:update')")
    public CommonResult<Boolean> updateItem(@Valid @RequestBody ItemUpdateReqVO updateReqVO) {
        itemService.updateItem(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除元素")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('alchemy:item:delete')")
    public CommonResult<Boolean> deleteItem(@RequestParam("id") Long id) {
        itemService.deleteItem(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得元素")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('alchemy:item:query')")
    public CommonResult<ItemRespVO> getItem(@RequestParam("id") Long id) {
        ItemDO item = itemService.getItem(id);
        return success(ItemConvert.INSTANCE.convert(item));
    }

    @GetMapping("/list")
    @Operation(summary = "获得元素列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('alchemy:item:query')")
    public CommonResult<List<ItemRespVO>> getItemList(@RequestParam("ids") Collection<Long> ids) {
        List<ItemDO> list = itemService.getItemList(ids);
        return success(ItemConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得元素分页")
    @PreAuthorize("@ss.hasPermission('alchemy:item:query')")
    public CommonResult<PageResult<ItemRespVO>> getItemPage(@Valid ItemPageReqVO pageVO) {
        PageResult<ItemDO> pageResult = itemService.getItemPage(pageVO);
        return success(ItemConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出元素 Excel")
    @PreAuthorize("@ss.hasPermission('alchemy:item:export')")
    @OperateLog(type = EXPORT)
    public void exportItemExcel(@Valid ItemExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ItemDO> list = itemService.getItemList(exportReqVO);
        // 导出 Excel
        List<ItemExcelVO> datas = ItemConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "元素.xls", "数据", ItemExcelVO.class, datas);
    }

}
