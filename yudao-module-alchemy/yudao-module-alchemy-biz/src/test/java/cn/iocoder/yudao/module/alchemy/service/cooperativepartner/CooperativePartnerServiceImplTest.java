package cn.iocoder.yudao.module.alchemy.service.cooperativepartner;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.alchemy.controller.admin.cooperativepartner.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.cooperativepartner.CooperativePartnerDO;
import cn.iocoder.yudao.module.alchemy.dal.mysql.cooperativepartner.CooperativePartnerMapper;
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
* {@link CooperativePartnerServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(CooperativePartnerServiceImpl.class)
public class CooperativePartnerServiceImplTest extends BaseDbUnitTest {

    @Resource
    private CooperativePartnerServiceImpl cooperativePartnerService;

    @Resource
    private CooperativePartnerMapper cooperativePartnerMapper;

    @Test
    public void testCreateCooperativePartner_success() {
        // 准备参数
        CooperativePartnerCreateReqVO reqVO = randomPojo(CooperativePartnerCreateReqVO.class);

        // 调用
        Long cooperativePartnerId = cooperativePartnerService.createCooperativePartner(reqVO);
        // 断言
        assertNotNull(cooperativePartnerId);
        // 校验记录的属性是否正确
        CooperativePartnerDO cooperativePartner = cooperativePartnerMapper.selectById(cooperativePartnerId);
        assertPojoEquals(reqVO, cooperativePartner);
    }

    @Test
    public void testUpdateCooperativePartner_success() {
        // mock 数据
        CooperativePartnerDO dbCooperativePartner = randomPojo(CooperativePartnerDO.class);
        cooperativePartnerMapper.insert(dbCooperativePartner);// @Sql: 先插入出一条存在的数据
        // 准备参数
        CooperativePartnerUpdateReqVO reqVO = randomPojo(CooperativePartnerUpdateReqVO.class, o -> {
            o.setId(dbCooperativePartner.getId()); // 设置更新的 ID
        });

        // 调用
        cooperativePartnerService.updateCooperativePartner(reqVO);
        // 校验是否更新正确
        CooperativePartnerDO cooperativePartner = cooperativePartnerMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, cooperativePartner);
    }

    @Test
    public void testUpdateCooperativePartner_notExists() {
        // 准备参数
        CooperativePartnerUpdateReqVO reqVO = randomPojo(CooperativePartnerUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> cooperativePartnerService.updateCooperativePartner(reqVO), COOPERATIVE_PARTNER_NOT_EXISTS);
    }

    @Test
    public void testDeleteCooperativePartner_success() {
        // mock 数据
        CooperativePartnerDO dbCooperativePartner = randomPojo(CooperativePartnerDO.class);
        cooperativePartnerMapper.insert(dbCooperativePartner);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbCooperativePartner.getId();

        // 调用
        cooperativePartnerService.deleteCooperativePartner(id);
       // 校验数据不存在了
       assertNull(cooperativePartnerMapper.selectById(id));
    }

    @Test
    public void testDeleteCooperativePartner_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> cooperativePartnerService.deleteCooperativePartner(id), COOPERATIVE_PARTNER_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCooperativePartnerPage() {
       // mock 数据
       CooperativePartnerDO dbCooperativePartner = randomPojo(CooperativePartnerDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setAvatar(null);
           o.setSort(null);
           o.setCreateTime(null);
       });
       cooperativePartnerMapper.insert(dbCooperativePartner);
       // 测试 name 不匹配
       cooperativePartnerMapper.insert(cloneIgnoreId(dbCooperativePartner, o -> o.setName(null)));
       // 测试 avatar 不匹配
       cooperativePartnerMapper.insert(cloneIgnoreId(dbCooperativePartner, o -> o.setAvatar(null)));
       // 测试 sort 不匹配
       cooperativePartnerMapper.insert(cloneIgnoreId(dbCooperativePartner, o -> o.setSort(null)));
       // 测试 createTime 不匹配
       cooperativePartnerMapper.insert(cloneIgnoreId(dbCooperativePartner, o -> o.setCreateTime(null)));
       // 准备参数
       CooperativePartnerPageReqVO reqVO = new CooperativePartnerPageReqVO();
       reqVO.setName(null);
       reqVO.setAvatar(null);
       reqVO.setSort(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<CooperativePartnerDO> pageResult = cooperativePartnerService.getCooperativePartnerPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbCooperativePartner, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCooperativePartnerList() {
       // mock 数据
       CooperativePartnerDO dbCooperativePartner = randomPojo(CooperativePartnerDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setAvatar(null);
           o.setSort(null);
           o.setCreateTime(null);
       });
       cooperativePartnerMapper.insert(dbCooperativePartner);
       // 测试 name 不匹配
       cooperativePartnerMapper.insert(cloneIgnoreId(dbCooperativePartner, o -> o.setName(null)));
       // 测试 avatar 不匹配
       cooperativePartnerMapper.insert(cloneIgnoreId(dbCooperativePartner, o -> o.setAvatar(null)));
       // 测试 sort 不匹配
       cooperativePartnerMapper.insert(cloneIgnoreId(dbCooperativePartner, o -> o.setSort(null)));
       // 测试 createTime 不匹配
       cooperativePartnerMapper.insert(cloneIgnoreId(dbCooperativePartner, o -> o.setCreateTime(null)));
       // 准备参数
       CooperativePartnerExportReqVO reqVO = new CooperativePartnerExportReqVO();
       reqVO.setName(null);
       reqVO.setAvatar(null);
       reqVO.setSort(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<CooperativePartnerDO> list = cooperativePartnerService.getCooperativePartnerList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbCooperativePartner, list.get(0));
    }

}
