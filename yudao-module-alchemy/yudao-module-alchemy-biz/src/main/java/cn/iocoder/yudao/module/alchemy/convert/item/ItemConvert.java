package cn.iocoder.yudao.module.alchemy.convert.item;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
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

    @Mappings({
            @Mapping(target = "name",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getName()))"),
            @Mapping(target = "intro",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getIntro()))"),
            @Mapping(target = "avatar",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getAvatar()))"),
            @Mapping(target = "carousel",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getCarousel()))"),
            @Mapping(target = "content",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getContent()))"),
            @Mapping(target = "doc",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getDoc()))"),
            @Mapping(target = "viewNum",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getViewNum()))"),
            @Mapping(target = "sort",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getSort()))")
    })
    ItemDO convert(ItemCreateReqVO bean);

    @Mappings({
            @Mapping(target = "name",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getName()))"),
            @Mapping(target = "intro",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getIntro()))"),
            @Mapping(target = "avatar",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getAvatar()))"),
            @Mapping(target = "carousel",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getCarousel()))"),
            @Mapping(target = "content",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getContent()))"),
            @Mapping(target = "doc",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getDoc()))"),
            @Mapping(target = "viewNum",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getViewNum()))"),
            @Mapping(target = "sort",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getSort()))")
    })
    ItemDO convert(ItemUpdateReqVO bean);

    @Mappings({
            @Mapping(target = "name",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getName(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str.class))"),
            @Mapping(target = "intro",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getIntro(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str.class))"),
            @Mapping(target = "avatar",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getAvatar(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str.class))"),
            @Mapping(target = "carousel",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getCarousel(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str.class))"),
            @Mapping(target = "content",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getContent(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str.class))"),
            @Mapping(target = "doc",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getDoc(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str.class))"),
            @Mapping(target = "viewNum",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getViewNum(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Lon.class))"),
            @Mapping(target = "sort",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getSort(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Lon.class))"),
    })
    ItemRespVO convert(ItemDO bean);

    List<ItemRespVO> convertList(List<ItemDO> list);

    PageResult<ItemRespVO> convertPage(PageResult<ItemDO> page);

    List<ItemExcelVO> convertList02(List<ItemDO> list);

}
