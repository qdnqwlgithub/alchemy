package cn.iocoder.yudao.module.alchemy.service.examplecategory;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.alchemy.controller.admin.examplecategory.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.examplecategory.ExampleCategoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 案例分类 Service 接口
 *
 * @author 芋道源码
 */
public interface ExampleCategoryService {

    /**
     * 创建案例分类
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExampleCategory(@Valid ExampleCategoryCreateReqVO createReqVO);

    /**
     * 更新案例分类
     *
     * @param updateReqVO 更新信息
     */
    void updateExampleCategory(@Valid ExampleCategoryUpdateReqVO updateReqVO);

    /**
     * 删除案例分类
     *
     * @param id 编号
     */
    void deleteExampleCategory(Long id);

    /**
     * 获得案例分类
     *
     * @param id 编号
     * @return 案例分类
     */
    ExampleCategoryDO getExampleCategory(Long id);

    /**
     * 获得案例分类列表
     *
     * @param ids 编号
     * @return 案例分类列表
     */
    List<ExampleCategoryDO> getExampleCategoryList(Collection<Long> ids);

    /**
     * 获得案例分类分页
     *
     * @param pageReqVO 分页查询
     * @return 案例分类分页
     */
    PageResult<ExampleCategoryDO> getExampleCategoryPage(ExampleCategoryPageReqVO pageReqVO);

    /**
     * 获得案例分类列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 案例分类列表
     */
    List<ExampleCategoryDO> getExampleCategoryList(ExampleCategoryExportReqVO exportReqVO);

}
