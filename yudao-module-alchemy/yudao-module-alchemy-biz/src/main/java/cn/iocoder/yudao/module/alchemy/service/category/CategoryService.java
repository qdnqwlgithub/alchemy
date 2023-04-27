package cn.iocoder.yudao.module.alchemy.service.category;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.category.CategoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 分类 Service 接口
 *
 * @author 芋道源码
 */
public interface CategoryService {

    /**
     * 创建分类
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createCategory(@Valid CategoryCreateReqVO createReqVO);

    /**
     * 更新分类
     *
     * @param updateReqVO 更新信息
     */
    void updateCategory(@Valid CategoryUpdateReqVO updateReqVO);

    /**
     * 删除分类
     *
     * @param id 编号
     */
    void deleteCategory(Long id);

    /**
     * 获得分类
     *
     * @param id 编号
     * @return 分类
     */
    CategoryDO getCategory(Long id);

    /**
     * 获得分类列表
     *
     * @param ids 编号
     * @return 分类列表
     */
    List<CategoryDO> getCategoryList(Collection<Long> ids);

    /**
     * 获得分类分页
     *
     * @param pageReqVO 分页查询
     * @return 分类分页
     */
    PageResult<CategoryDO> getCategoryPage(CategoryPageReqVO pageReqVO);

    /**
     * 获得分类列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 分类列表
     */
    List<CategoryDO> getCategoryList(CategoryExportReqVO exportReqVO);

}
