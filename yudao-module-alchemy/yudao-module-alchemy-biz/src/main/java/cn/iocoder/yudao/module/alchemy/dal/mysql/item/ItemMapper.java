package cn.iocoder.yudao.module.alchemy.dal.mysql.item;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.item.ItemDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.alchemy.controller.admin.item.vo.*;

/**
 * 元素 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ItemMapper extends BaseMapperX<ItemDO> {

    default PageResult<ItemDO> selectPage(ItemPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ItemDO>()
                .likeIfPresent(ItemDO::getName, reqVO.getName())
                .eqIfPresent(ItemDO::getIntro, reqVO.getIntro())
                .eqIfPresent(ItemDO::getCId, reqVO.getCId())
                .eqIfPresent(ItemDO::getAvatar, reqVO.getAvatar())
                .eqIfPresent(ItemDO::getCarousel, reqVO.getCarousel())
                .eqIfPresent(ItemDO::getContent, reqVO.getContent())
                .eqIfPresent(ItemDO::getDoc, reqVO.getDoc())
                .eqIfPresent(ItemDO::getViewNum, reqVO.getViewNum())
                .eqIfPresent(ItemDO::getSort, reqVO.getSort())
                .eqIfPresent(ItemDO::getCreateBy, reqVO.getCreateBy())
                .betweenIfPresent(ItemDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ItemDO::getUpdateBy, reqVO.getUpdateBy())
                .orderByDesc(ItemDO::getId));
    }

    default List<ItemDO> selectList(ItemExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ItemDO>()
                .likeIfPresent(ItemDO::getName, reqVO.getName())
                .eqIfPresent(ItemDO::getIntro, reqVO.getIntro())
                .eqIfPresent(ItemDO::getCId, reqVO.getCId())
                .eqIfPresent(ItemDO::getAvatar, reqVO.getAvatar())
                .eqIfPresent(ItemDO::getCarousel, reqVO.getCarousel())
                .eqIfPresent(ItemDO::getContent, reqVO.getContent())
                .eqIfPresent(ItemDO::getDoc, reqVO.getDoc())
                .eqIfPresent(ItemDO::getViewNum, reqVO.getViewNum())
                .eqIfPresent(ItemDO::getSort, reqVO.getSort())
                .eqIfPresent(ItemDO::getCreateBy, reqVO.getCreateBy())
                .betweenIfPresent(ItemDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ItemDO::getUpdateBy, reqVO.getUpdateBy())
                .orderByDesc(ItemDO::getId));
    }

}
