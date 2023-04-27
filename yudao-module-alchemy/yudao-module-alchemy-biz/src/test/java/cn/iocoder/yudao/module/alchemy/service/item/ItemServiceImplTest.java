package cn.iocoder.yudao.module.alchemy.service.item;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.alchemy.controller.admin.item.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.item.ItemDO;
import cn.iocoder.yudao.module.alchemy.dal.mysql.item.ItemMapper;
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
* {@link ItemServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(ItemServiceImpl.class)
public class ItemServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ItemServiceImpl itemService;

    @Resource
    private ItemMapper itemMapper;

    @Test
    public void testCreateItem_success() {
        // 准备参数
        ItemCreateReqVO reqVO = randomPojo(ItemCreateReqVO.class);

        // 调用
        Long itemId = itemService.createItem(reqVO);
        // 断言
        assertNotNull(itemId);
        // 校验记录的属性是否正确
        ItemDO item = itemMapper.selectById(itemId);
        assertPojoEquals(reqVO, item);
    }

    @Test
    public void testUpdateItem_success() {
        // mock 数据
        ItemDO dbItem = randomPojo(ItemDO.class);
        itemMapper.insert(dbItem);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ItemUpdateReqVO reqVO = randomPojo(ItemUpdateReqVO.class, o -> {
            o.setId(dbItem.getId()); // 设置更新的 ID
        });

        // 调用
        itemService.updateItem(reqVO);
        // 校验是否更新正确
        ItemDO item = itemMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, item);
    }

    @Test
    public void testUpdateItem_notExists() {
        // 准备参数
        ItemUpdateReqVO reqVO = randomPojo(ItemUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> itemService.updateItem(reqVO), ITEM_NOT_EXISTS);
    }

    @Test
    public void testDeleteItem_success() {
        // mock 数据
        ItemDO dbItem = randomPojo(ItemDO.class);
        itemMapper.insert(dbItem);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbItem.getId();

        // 调用
        itemService.deleteItem(id);
       // 校验数据不存在了
       assertNull(itemMapper.selectById(id));
    }

    @Test
    public void testDeleteItem_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> itemService.deleteItem(id), ITEM_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetItemPage() {
       // mock 数据
       ItemDO dbItem = randomPojo(ItemDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setIntro(null);
           o.setCId(null);
           o.setAvatar(null);
           o.setCarousel(null);
           o.setContent(null);
           o.setDoc(null);
           o.setViewNum(null);
           o.setSort(null);
           o.setCreateBy(null);
           o.setCreateTime(null);
           o.setUpdateBy(null);
       });
       itemMapper.insert(dbItem);
       // 测试 name 不匹配
       itemMapper.insert(cloneIgnoreId(dbItem, o -> o.setName(null)));
       // 测试 intro 不匹配
       itemMapper.insert(cloneIgnoreId(dbItem, o -> o.setIntro(null)));
       // 测试 cId 不匹配
       itemMapper.insert(cloneIgnoreId(dbItem, o -> o.setCId(null)));
       // 测试 avatar 不匹配
       itemMapper.insert(cloneIgnoreId(dbItem, o -> o.setAvatar(null)));
       // 测试 carousel 不匹配
       itemMapper.insert(cloneIgnoreId(dbItem, o -> o.setCarousel(null)));
       // 测试 content 不匹配
       itemMapper.insert(cloneIgnoreId(dbItem, o -> o.setContent(null)));
       // 测试 doc 不匹配
       itemMapper.insert(cloneIgnoreId(dbItem, o -> o.setDoc(null)));
       // 测试 viewNum 不匹配
       itemMapper.insert(cloneIgnoreId(dbItem, o -> o.setViewNum(null)));
       // 测试 sort 不匹配
       itemMapper.insert(cloneIgnoreId(dbItem, o -> o.setSort(null)));
       // 测试 createBy 不匹配
       itemMapper.insert(cloneIgnoreId(dbItem, o -> o.setCreateBy(null)));
       // 测试 createTime 不匹配
       itemMapper.insert(cloneIgnoreId(dbItem, o -> o.setCreateTime(null)));
       // 测试 updateBy 不匹配
       itemMapper.insert(cloneIgnoreId(dbItem, o -> o.setUpdateBy(null)));
       // 准备参数
       ItemPageReqVO reqVO = new ItemPageReqVO();
       reqVO.setName(null);
       reqVO.setIntro(null);
       reqVO.setCId(null);
       reqVO.setAvatar(null);
       reqVO.setCarousel(null);
       reqVO.setContent(null);
       reqVO.setDoc(null);
       reqVO.setViewNum(null);
       reqVO.setSort(null);
       reqVO.setCreateBy(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setUpdateBy(null);

       // 调用
       PageResult<ItemDO> pageResult = itemService.getItemPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbItem, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetItemList() {
       // mock 数据
       ItemDO dbItem = randomPojo(ItemDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setIntro(null);
           o.setCId(null);
           o.setAvatar(null);
           o.setCarousel(null);
           o.setContent(null);
           o.setDoc(null);
           o.setViewNum(null);
           o.setSort(null);
           o.setCreateBy(null);
           o.setCreateTime(null);
           o.setUpdateBy(null);
       });
       itemMapper.insert(dbItem);
       // 测试 name 不匹配
       itemMapper.insert(cloneIgnoreId(dbItem, o -> o.setName(null)));
       // 测试 intro 不匹配
       itemMapper.insert(cloneIgnoreId(dbItem, o -> o.setIntro(null)));
       // 测试 cId 不匹配
       itemMapper.insert(cloneIgnoreId(dbItem, o -> o.setCId(null)));
       // 测试 avatar 不匹配
       itemMapper.insert(cloneIgnoreId(dbItem, o -> o.setAvatar(null)));
       // 测试 carousel 不匹配
       itemMapper.insert(cloneIgnoreId(dbItem, o -> o.setCarousel(null)));
       // 测试 content 不匹配
       itemMapper.insert(cloneIgnoreId(dbItem, o -> o.setContent(null)));
       // 测试 doc 不匹配
       itemMapper.insert(cloneIgnoreId(dbItem, o -> o.setDoc(null)));
       // 测试 viewNum 不匹配
       itemMapper.insert(cloneIgnoreId(dbItem, o -> o.setViewNum(null)));
       // 测试 sort 不匹配
       itemMapper.insert(cloneIgnoreId(dbItem, o -> o.setSort(null)));
       // 测试 createBy 不匹配
       itemMapper.insert(cloneIgnoreId(dbItem, o -> o.setCreateBy(null)));
       // 测试 createTime 不匹配
       itemMapper.insert(cloneIgnoreId(dbItem, o -> o.setCreateTime(null)));
       // 测试 updateBy 不匹配
       itemMapper.insert(cloneIgnoreId(dbItem, o -> o.setUpdateBy(null)));
       // 准备参数
       ItemExportReqVO reqVO = new ItemExportReqVO();
       reqVO.setName(null);
       reqVO.setIntro(null);
       reqVO.setCId(null);
       reqVO.setAvatar(null);
       reqVO.setCarousel(null);
       reqVO.setContent(null);
       reqVO.setDoc(null);
       reqVO.setViewNum(null);
       reqVO.setSort(null);
       reqVO.setCreateBy(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setUpdateBy(null);

       // 调用
       List<ItemDO> list = itemService.getItemList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbItem, list.get(0));
    }

}
