package cn.iocoder.yudao.module.alchemy.service.item;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.alchemy.controller.admin.item.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.item.ItemDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.alchemy.convert.item.ItemConvert;
import cn.iocoder.yudao.module.alchemy.dal.mysql.item.ItemMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.alchemy.enums.ErrorCodeConstants.*;

/**
 * 元素 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ItemServiceImpl implements ItemService {

    @Resource
    private ItemMapper itemMapper;

    @Override
    public Long createItem(ItemCreateReqVO createReqVO) {
        // 插入
        ItemDO item = ItemConvert.INSTANCE.convert(createReqVO);
        itemMapper.insert(item);
        // 返回
        return item.getId();
    }

    @Override
    public void updateItem(ItemUpdateReqVO updateReqVO) {
        // 校验存在
        validateItemExists(updateReqVO.getId());
        // 更新
        ItemDO updateObj = ItemConvert.INSTANCE.convert(updateReqVO);
        itemMapper.updateById(updateObj);
    }

    @Override
    public void deleteItem(Long id) {
        // 校验存在
        validateItemExists(id);
        // 删除
        itemMapper.deleteById(id);
    }

    private void validateItemExists(Long id) {
        if (itemMapper.selectById(id) == null) {
            throw exception(ITEM_NOT_EXISTS);
        }
    }

    @Override
    public ItemDO getItem(Long id) {
        return itemMapper.selectById(id);
    }

    @Override
    public List<ItemDO> getItemList(Collection<Long> ids) {
        return itemMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ItemDO> getItemPage(ItemPageReqVO pageReqVO) {
        return itemMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ItemDO> getItemList(ItemExportReqVO exportReqVO) {
        return itemMapper.selectList(exportReqVO);
    }

}
