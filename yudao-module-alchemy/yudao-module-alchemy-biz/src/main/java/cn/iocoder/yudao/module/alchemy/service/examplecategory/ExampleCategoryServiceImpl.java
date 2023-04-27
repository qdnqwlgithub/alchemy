package cn.iocoder.yudao.module.alchemy.service.examplecategory;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.alchemy.controller.admin.examplecategory.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.examplecategory.ExampleCategoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.alchemy.convert.examplecategory.ExampleCategoryConvert;
import cn.iocoder.yudao.module.alchemy.dal.mysql.examplecategory.ExampleCategoryMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.alchemy.enums.ErrorCodeConstants.*;

/**
 * 案例分类 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ExampleCategoryServiceImpl implements ExampleCategoryService {

    @Resource
    private ExampleCategoryMapper exampleCategoryMapper;

    @Override
    public Long createExampleCategory(ExampleCategoryCreateReqVO createReqVO) {
        // 插入
        ExampleCategoryDO exampleCategory = ExampleCategoryConvert.INSTANCE.convert(createReqVO);
        exampleCategoryMapper.insert(exampleCategory);
        // 返回
        return exampleCategory.getId();
    }

    @Override
    public void updateExampleCategory(ExampleCategoryUpdateReqVO updateReqVO) {
        // 校验存在
        validateExampleCategoryExists(updateReqVO.getId());
        // 更新
        ExampleCategoryDO updateObj = ExampleCategoryConvert.INSTANCE.convert(updateReqVO);
        exampleCategoryMapper.updateById(updateObj);
    }

    @Override
    public void deleteExampleCategory(Long id) {
        // 校验存在
        validateExampleCategoryExists(id);
        // 删除
        exampleCategoryMapper.deleteById(id);
    }

    private void validateExampleCategoryExists(Long id) {
        if (exampleCategoryMapper.selectById(id) == null) {
            throw exception(EXAMPLE_CATEGORY_NOT_EXISTS);
        }
    }

    @Override
    public ExampleCategoryDO getExampleCategory(Long id) {
        return exampleCategoryMapper.selectById(id);
    }

    @Override
    public List<ExampleCategoryDO> getExampleCategoryList(Collection<Long> ids) {
        return exampleCategoryMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ExampleCategoryDO> getExampleCategoryPage(ExampleCategoryPageReqVO pageReqVO) {
        return exampleCategoryMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ExampleCategoryDO> getExampleCategoryList(ExampleCategoryExportReqVO exportReqVO) {
        return exampleCategoryMapper.selectList(exportReqVO);
    }

}
