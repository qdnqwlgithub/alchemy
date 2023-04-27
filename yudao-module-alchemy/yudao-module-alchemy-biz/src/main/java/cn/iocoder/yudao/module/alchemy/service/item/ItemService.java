package cn.iocoder.yudao.module.alchemy.service.item;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.alchemy.controller.admin.item.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.item.ItemDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 元素 Service 接口
 *
 * @author 芋道源码
 */
public interface ItemService {

    /**
     * 创建元素
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createItem(@Valid ItemCreateReqVO createReqVO);

    /**
     * 更新元素
     *
     * @param updateReqVO 更新信息
     */
    void updateItem(@Valid ItemUpdateReqVO updateReqVO);

    /**
     * 删除元素
     *
     * @param id 编号
     */
    void deleteItem(Long id);

    /**
     * 获得元素
     *
     * @param id 编号
     * @return 元素
     */
    ItemDO getItem(Long id);

    /**
     * 获得元素列表
     *
     * @param ids 编号
     * @return 元素列表
     */
    List<ItemDO> getItemList(Collection<Long> ids);

    /**
     * 获得元素分页
     *
     * @param pageReqVO 分页查询
     * @return 元素分页
     */
    PageResult<ItemDO> getItemPage(ItemPageReqVO pageReqVO);

    /**
     * 获得元素列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 元素列表
     */
    List<ItemDO> getItemList(ItemExportReqVO exportReqVO);

}
