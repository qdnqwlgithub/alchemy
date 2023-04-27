package cn.iocoder.yudao.module.alchemy.service.examplecategory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.alchemy.controller.admin.examplecategory.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.examplecategory.ExampleCategoryDO;
import cn.iocoder.yudao.module.alchemy.dal.mysql.examplecategory.ExampleCategoryMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.module.alchemy.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link ExampleCategoryServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(ExampleCategoryServiceImpl.class)
public class ExampleCategoryServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ExampleCategoryServiceImpl exampleCategoryService;

    @Resource
    private ExampleCategoryMapper exampleCategoryMapper;

    @Test
    public void testCreateExampleCategory_success() {
        // 准备参数
        ExampleCategoryCreateReqVO reqVO = randomPojo(ExampleCategoryCreateReqVO.class);

        // 调用
        Long exampleCategoryId = exampleCategoryService.createExampleCategory(reqVO);
        // 断言
        assertNotNull(exampleCategoryId);
        // 校验记录的属性是否正确
        ExampleCategoryDO exampleCategory = exampleCategoryMapper.selectById(exampleCategoryId);
        assertPojoEquals(reqVO, exampleCategory);
    }

    @Test
    public void testUpdateExampleCategory_success() {
        // mock 数据
        ExampleCategoryDO dbExampleCategory = randomPojo(ExampleCategoryDO.class);
        exampleCategoryMapper.insert(dbExampleCategory);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ExampleCategoryUpdateReqVO reqVO = randomPojo(ExampleCategoryUpdateReqVO.class, o -> {
            o.setId(dbExampleCategory.getId()); // 设置更新的 ID
        });

        // 调用
        exampleCategoryService.updateExampleCategory(reqVO);
        // 校验是否更新正确
        ExampleCategoryDO exampleCategory = exampleCategoryMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, exampleCategory);
    }

    @Test
    public void testUpdateExampleCategory_notExists() {
        // 准备参数
        ExampleCategoryUpdateReqVO reqVO = randomPojo(ExampleCategoryUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> exampleCategoryService.updateExampleCategory(reqVO), EXAMPLE_CATEGORY_NOT_EXISTS);
    }

    @Test
    public void testDeleteExampleCategory_success() {
        // mock 数据
        ExampleCategoryDO dbExampleCategory = randomPojo(ExampleCategoryDO.class);
        exampleCategoryMapper.insert(dbExampleCategory);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbExampleCategory.getId();

        // 调用
        exampleCategoryService.deleteExampleCategory(id);
       // 校验数据不存在了
       assertNull(exampleCategoryMapper.selectById(id));
    }

    @Test
    public void testDeleteExampleCategory_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> exampleCategoryService.deleteExampleCategory(id), EXAMPLE_CATEGORY_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetExampleCategoryPage() {
       // mock 数据
       ExampleCategoryDO dbExampleCategory = randomPojo(ExampleCategoryDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setSort(null);
           o.setCreateBy(null);
           o.setCreateTime(null);
           o.setUpdateBy(null);
       });
       exampleCategoryMapper.insert(dbExampleCategory);
       // 测试 name 不匹配
       exampleCategoryMapper.insert(cloneIgnoreId(dbExampleCategory, o -> o.setName(null)));
       // 测试 sort 不匹配
       exampleCategoryMapper.insert(cloneIgnoreId(dbExampleCategory, o -> o.setSort(null)));
       // 测试 createBy 不匹配
       exampleCategoryMapper.insert(cloneIgnoreId(dbExampleCategory, o -> o.setCreateBy(null)));
       // 测试 createTime 不匹配
       exampleCategoryMapper.insert(cloneIgnoreId(dbExampleCategory, o -> o.setCreateTime(null)));
       // 测试 updateBy 不匹配
       exampleCategoryMapper.insert(cloneIgnoreId(dbExampleCategory, o -> o.setUpdateBy(null)));
       // 准备参数
       ExampleCategoryPageReqVO reqVO = new ExampleCategoryPageReqVO();
       reqVO.setName(null);
       reqVO.setSort(null);
       reqVO.setCreateBy(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setUpdateBy(null);

       // 调用
       PageResult<ExampleCategoryDO> pageResult = exampleCategoryService.getExampleCategoryPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbExampleCategory, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetExampleCategoryList() {
       // mock 数据
       ExampleCategoryDO dbExampleCategory = randomPojo(ExampleCategoryDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setSort(null);
           o.setCreateBy(null);
           o.setCreateTime(null);
           o.setUpdateBy(null);
       });
       exampleCategoryMapper.insert(dbExampleCategory);
       // 测试 name 不匹配
       exampleCategoryMapper.insert(cloneIgnoreId(dbExampleCategory, o -> o.setName(null)));
       // 测试 sort 不匹配
       exampleCategoryMapper.insert(cloneIgnoreId(dbExampleCategory, o -> o.setSort(null)));
       // 测试 createBy 不匹配
       exampleCategoryMapper.insert(cloneIgnoreId(dbExampleCategory, o -> o.setCreateBy(null)));
       // 测试 createTime 不匹配
       exampleCategoryMapper.insert(cloneIgnoreId(dbExampleCategory, o -> o.setCreateTime(null)));
       // 测试 updateBy 不匹配
       exampleCategoryMapper.insert(cloneIgnoreId(dbExampleCategory, o -> o.setUpdateBy(null)));
       // 准备参数
       ExampleCategoryExportReqVO reqVO = new ExampleCategoryExportReqVO();
       reqVO.setName(null);
       reqVO.setSort(null);
       reqVO.setCreateBy(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setUpdateBy(null);

       // 调用
       List<ExampleCategoryDO> list = exampleCategoryService.getExampleCategoryList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbExampleCategory, list.get(0));
    }

}
