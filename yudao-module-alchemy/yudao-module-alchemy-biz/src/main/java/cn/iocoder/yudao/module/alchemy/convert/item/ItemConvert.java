package cn.iocoder.yudao.module.alchemy.convert.item;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.alchemy.controller.admin.item.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.item.ItemDO;

/**
 * 元素 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ItemConvert {

    ItemConvert INSTANCE = Mappers.getMapper(ItemConvert.class);

    ItemDO convert(ItemCreateReqVO bean);

    ItemDO convert(ItemUpdateReqVO bean);

    ItemRespVO convert(ItemDO bean);

    List<ItemRespVO> convertList(List<ItemDO> list);

    PageResult<ItemRespVO> convertPage(PageResult<ItemDO> page);

    List<ItemExcelVO> convertList02(List<ItemDO> list);

}
