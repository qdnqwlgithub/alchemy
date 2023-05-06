package cn.iocoder.yudao.module.alchemy.service.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.alchemy.controller.admin.example.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.example.ExampleDO;
import cn.iocoder.yudao.module.alchemy.dal.mysql.example.ExampleMapper;
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
* {@link ExampleServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(ExampleServiceImpl.class)
public class ExampleServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ExampleServiceImpl exampleService;

    @Resource
    private ExampleMapper exampleMapper;

    @Test
    public void testCreateExample_success() {
        // 准备参数
        ExampleCreateReqVO reqVO = randomPojo(ExampleCreateReqVO.class);

        // 调用
        Long exampleId = exampleService.createExample(reqVO);
        // 断言
        assertNotNull(exampleId);
        // 校验记录的属性是否正确
        ExampleDO example = exampleMapper.selectById(exampleId);
        assertPojoEquals(reqVO, example);
    }

    @Test
    public void testUpdateExample_success() {
        // mock 数据
        ExampleDO dbExample = randomPojo(ExampleDO.class);
        exampleMapper.insert(dbExample);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ExampleUpdateReqVO reqVO = randomPojo(ExampleUpdateReqVO.class, o -> {
            o.setId(dbExample.getId()); // 设置更新的 ID
        });

        // 调用
        exampleService.updateExample(reqVO);
        // 校验是否更新正确
        ExampleDO example = exampleMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, example);
    }

    @Test
    public void testUpdateExample_notExists() {
        // 准备参数
        ExampleUpdateReqVO reqVO = randomPojo(ExampleUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> exampleService.updateExample(reqVO), EXAMPLE_NOT_EXISTS);
    }

    @Test
    public void testDeleteExample_success() {
        // mock 数据
        ExampleDO dbExample = randomPojo(ExampleDO.class);
        exampleMapper.insert(dbExample);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbExample.getId();

        // 调用
        exampleService.deleteExample(id);
       // 校验数据不存在了
       assertNull(exampleMapper.selectById(id));
    }

    @Test
    public void testDeleteExample_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> exampleService.deleteExample(id), EXAMPLE_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetExamplePage() {
       // mock 数据
       ExampleDO dbExample = randomPojo(ExampleDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setCategoryId(null);
           o.setAvatar(null);
           o.setCarousel(null);
           o.setContent(null);
           o.setSort(null);
           o.setIndexFlag(null);
           o.setIndexSort(null);
       });
       exampleMapper.insert(dbExample);
       // 测试 name 不匹配
       exampleMapper.insert(cloneIgnoreId(dbExample, o -> o.setName(null)));
       // 测试 categoryId 不匹配
       exampleMapper.insert(cloneIgnoreId(dbExample, o -> o.setCategoryId(null)));
       // 测试 avatar 不匹配
       exampleMapper.insert(cloneIgnoreId(dbExample, o -> o.setAvatar(null)));
       // 测试 carousel 不匹配
       exampleMapper.insert(cloneIgnoreId(dbExample, o -> o.setCarousel(null)));
       // 测试 content 不匹配
       exampleMapper.insert(cloneIgnoreId(dbExample, o -> o.setContent(null)));
       // 测试 sort 不匹配
       exampleMapper.insert(cloneIgnoreId(dbExample, o -> o.setSort(null)));
       // 测试 indexFlag 不匹配
       exampleMapper.insert(cloneIgnoreId(dbExample, o -> o.setIndexFlag(null)));
       // 测试 indexSort 不匹配
       exampleMapper.insert(cloneIgnoreId(dbExample, o -> o.setIndexSort(null)));
       // 准备参数
       ExamplePageReqVO reqVO = new ExamplePageReqVO();
       reqVO.setName(null);
       reqVO.setCategoryId(null);
       reqVO.setAvatar(null);
       reqVO.setCarousel(null);
       reqVO.setContent(null);
       reqVO.setSort(null);
       reqVO.setIndexFlag(null);
       reqVO.setIndexSort(null);

       // 调用
       PageResult<ExampleDO> pageResult = exampleService.getExamplePage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbExample, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetExampleList() {
       // mock 数据
       ExampleDO dbExample = randomPojo(ExampleDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setCategoryId(null);
           o.setAvatar(null);
           o.setCarousel(null);
           o.setContent(null);
           o.setSort(null);
           o.setIndexFlag(null);
           o.setIndexSort(null);
       });
       exampleMapper.insert(dbExample);
       // 测试 name 不匹配
       exampleMapper.insert(cloneIgnoreId(dbExample, o -> o.setName(null)));
       // 测试 categoryId 不匹配
       exampleMapper.insert(cloneIgnoreId(dbExample, o -> o.setCategoryId(null)));
       // 测试 avatar 不匹配
       exampleMapper.insert(cloneIgnoreId(dbExample, o -> o.setAvatar(null)));
       // 测试 carousel 不匹配
       exampleMapper.insert(cloneIgnoreId(dbExample, o -> o.setCarousel(null)));
       // 测试 content 不匹配
       exampleMapper.insert(cloneIgnoreId(dbExample, o -> o.setContent(null)));
       // 测试 sort 不匹配
       exampleMapper.insert(cloneIgnoreId(dbExample, o -> o.setSort(null)));
       // 测试 indexFlag 不匹配
       exampleMapper.insert(cloneIgnoreId(dbExample, o -> o.setIndexFlag(null)));
       // 测试 indexSort 不匹配
       exampleMapper.insert(cloneIgnoreId(dbExample, o -> o.setIndexSort(null)));
       // 准备参数
       ExampleExportReqVO reqVO = new ExampleExportReqVO();
       reqVO.setName(null);
       reqVO.setCategoryId(null);
       reqVO.setAvatar(null);
       reqVO.setCarousel(null);
       reqVO.setContent(null);
       reqVO.setSort(null);
       reqVO.setIndexFlag(null);
       reqVO.setIndexSort(null);

       // 调用
       List<ExampleDO> list = exampleService.getExampleList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbExample, list.get(0));
    }

}
