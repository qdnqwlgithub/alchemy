package cn.iocoder.yudao.module.alchemy.service.miniappconfig;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.alchemy.controller.admin.miniappconfig.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.miniappconfig.MiniAppConfigDO;
import cn.iocoder.yudao.module.alchemy.dal.mysql.miniappconfig.MiniAppConfigMapper;
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
* {@link MiniAppConfigServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(MiniAppConfigServiceImpl.class)
public class MiniAppConfigServiceImplTest extends BaseDbUnitTest {

    @Resource
    private MiniAppConfigServiceImpl miniAppConfigService;

    @Resource
    private MiniAppConfigMapper miniAppConfigMapper;

    @Test
    public void testCreateMiniAppConfig_success() {
        // 准备参数
        MiniAppConfigCreateReqVO reqVO = randomPojo(MiniAppConfigCreateReqVO.class);

        // 调用
        Long miniAppConfigId = miniAppConfigService.createMiniAppConfig(reqVO);
        // 断言
        assertNotNull(miniAppConfigId);
        // 校验记录的属性是否正确
        MiniAppConfigDO miniAppConfig = miniAppConfigMapper.selectById(miniAppConfigId);
        assertPojoEquals(reqVO, miniAppConfig);
    }

    @Test
    public void testUpdateMiniAppConfig_success() {
        // mock 数据
        MiniAppConfigDO dbMiniAppConfig = randomPojo(MiniAppConfigDO.class);
        miniAppConfigMapper.insert(dbMiniAppConfig);// @Sql: 先插入出一条存在的数据
        // 准备参数
        MiniAppConfigUpdateReqVO reqVO = randomPojo(MiniAppConfigUpdateReqVO.class, o -> {
            o.setId(dbMiniAppConfig.getId()); // 设置更新的 ID
        });

        // 调用
        miniAppConfigService.updateMiniAppConfig(reqVO);
        // 校验是否更新正确
        MiniAppConfigDO miniAppConfig = miniAppConfigMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, miniAppConfig);
    }

    @Test
    public void testUpdateMiniAppConfig_notExists() {
        // 准备参数
        MiniAppConfigUpdateReqVO reqVO = randomPojo(MiniAppConfigUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> miniAppConfigService.updateMiniAppConfig(reqVO), MINI_APP_CONFIG_NOT_EXISTS);
    }

    @Test
    public void testDeleteMiniAppConfig_success() {
        // mock 数据
        MiniAppConfigDO dbMiniAppConfig = randomPojo(MiniAppConfigDO.class);
        miniAppConfigMapper.insert(dbMiniAppConfig);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbMiniAppConfig.getId();

        // 调用
        miniAppConfigService.deleteMiniAppConfig(id);
       // 校验数据不存在了
       assertNull(miniAppConfigMapper.selectById(id));
    }

    @Test
    public void testDeleteMiniAppConfig_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> miniAppConfigService.deleteMiniAppConfig(id), MINI_APP_CONFIG_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMiniAppConfigPage() {
       // mock 数据
       MiniAppConfigDO dbMiniAppConfig = randomPojo(MiniAppConfigDO.class, o -> { // 等会查询到
           o.setHeadImg(null);
           o.setCarousel(null);
           o.setIndexBottomImg(null);
           o.setCompanyName(null);
           o.setAddress(null);
           o.setPhoneNumber(null);
           o.setEmail(null);
           o.setPosition(null);
           o.setCreateTime(null);
       });
       miniAppConfigMapper.insert(dbMiniAppConfig);
       // 测试 headImg 不匹配
       miniAppConfigMapper.insert(cloneIgnoreId(dbMiniAppConfig, o -> o.setHeadImg(null)));
       // 测试 carousel 不匹配
       miniAppConfigMapper.insert(cloneIgnoreId(dbMiniAppConfig, o -> o.setCarousel(null)));
       // 测试 indexBottomImg 不匹配
       miniAppConfigMapper.insert(cloneIgnoreId(dbMiniAppConfig, o -> o.setIndexBottomImg(null)));
       // 测试 companyName 不匹配
       miniAppConfigMapper.insert(cloneIgnoreId(dbMiniAppConfig, o -> o.setCompanyName(null)));
       // 测试 address 不匹配
       miniAppConfigMapper.insert(cloneIgnoreId(dbMiniAppConfig, o -> o.setAddress(null)));
       // 测试 phoneNumber 不匹配
       miniAppConfigMapper.insert(cloneIgnoreId(dbMiniAppConfig, o -> o.setPhoneNumber(null)));
       // 测试 email 不匹配
       miniAppConfigMapper.insert(cloneIgnoreId(dbMiniAppConfig, o -> o.setEmail(null)));
       // 测试 position 不匹配
       miniAppConfigMapper.insert(cloneIgnoreId(dbMiniAppConfig, o -> o.setPosition(null)));
       // 测试 createTime 不匹配
       miniAppConfigMapper.insert(cloneIgnoreId(dbMiniAppConfig, o -> o.setCreateTime(null)));
       // 准备参数
       MiniAppConfigPageReqVO reqVO = new MiniAppConfigPageReqVO();
       reqVO.setHeadImg(null);
       reqVO.setCarousel(null);
       reqVO.setIndexBottomImg(null);
       reqVO.setCompanyName(null);
       reqVO.setAddress(null);
       reqVO.setPhoneNumber(null);
       reqVO.setEmail(null);
       reqVO.setPosition(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<MiniAppConfigDO> pageResult = miniAppConfigService.getMiniAppConfigPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbMiniAppConfig, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMiniAppConfigList() {
       // mock 数据
       MiniAppConfigDO dbMiniAppConfig = randomPojo(MiniAppConfigDO.class, o -> { // 等会查询到
           o.setHeadImg(null);
           o.setCarousel(null);
           o.setIndexBottomImg(null);
           o.setCompanyName(null);
           o.setAddress(null);
           o.setPhoneNumber(null);
           o.setEmail(null);
           o.setPosition(null);
           o.setCreateTime(null);
       });
       miniAppConfigMapper.insert(dbMiniAppConfig);
       // 测试 headImg 不匹配
       miniAppConfigMapper.insert(cloneIgnoreId(dbMiniAppConfig, o -> o.setHeadImg(null)));
       // 测试 carousel 不匹配
       miniAppConfigMapper.insert(cloneIgnoreId(dbMiniAppConfig, o -> o.setCarousel(null)));
       // 测试 indexBottomImg 不匹配
       miniAppConfigMapper.insert(cloneIgnoreId(dbMiniAppConfig, o -> o.setIndexBottomImg(null)));
       // 测试 companyName 不匹配
       miniAppConfigMapper.insert(cloneIgnoreId(dbMiniAppConfig, o -> o.setCompanyName(null)));
       // 测试 address 不匹配
       miniAppConfigMapper.insert(cloneIgnoreId(dbMiniAppConfig, o -> o.setAddress(null)));
       // 测试 phoneNumber 不匹配
       miniAppConfigMapper.insert(cloneIgnoreId(dbMiniAppConfig, o -> o.setPhoneNumber(null)));
       // 测试 email 不匹配
       miniAppConfigMapper.insert(cloneIgnoreId(dbMiniAppConfig, o -> o.setEmail(null)));
       // 测试 position 不匹配
       miniAppConfigMapper.insert(cloneIgnoreId(dbMiniAppConfig, o -> o.setPosition(null)));
       // 测试 createTime 不匹配
       miniAppConfigMapper.insert(cloneIgnoreId(dbMiniAppConfig, o -> o.setCreateTime(null)));
       // 准备参数
       MiniAppConfigExportReqVO reqVO = new MiniAppConfigExportReqVO();
       reqVO.setHeadImg(null);
       reqVO.setCarousel(null);
       reqVO.setIndexBottomImg(null);
       reqVO.setCompanyName(null);
       reqVO.setAddress(null);
       reqVO.setPhoneNumber(null);
       reqVO.setEmail(null);
       reqVO.setPosition(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<MiniAppConfigDO> list = miniAppConfigService.getMiniAppConfigList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbMiniAppConfig, list.get(0));
    }

}
