package cn.iocoder.yudao.module.alchemy.convert.example;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.alchemy.controller.admin.example.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.example.ExampleDO;

/**
 * 案例 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ExampleConvert {

    ExampleConvert INSTANCE = Mappers.getMapper(ExampleConvert.class);

    @Mappings({
            @Mapping(target = "name",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getName()))"),
            @Mapping(target = "avatar",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getAvatar()))"),
            @Mapping(target = "carousel",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getCarousel()))"),
            @Mapping(target = "content",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getContent()))"),
            @Mapping(target = "sort",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getSort()))"),
            @Mapping(target = "indexFlag",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getIndexFlag()))"),
            @Mapping(target = "indexSort",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getIndexSort()))")
    })
    ExampleDO convert(ExampleCreateReqVO bean);

    @Mappings({
            @Mapping(target = "name",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getName()))"),
            @Mapping(target = "avatar",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getAvatar()))"),
            @Mapping(target = "carousel",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getCarousel()))"),
            @Mapping(target = "content",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getContent()))"),
            @Mapping(target = "sort",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getSort()))"),
            @Mapping(target = "indexFlag",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getIndexFlag()))"),
            @Mapping(target = "indexSort",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getIndexSort()))")
    })
    ExampleDO convert(ExampleUpdateReqVO bean);

    @Mappings({
            @Mapping(target = "name",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getName(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str.class))"),
            @Mapping(target = "avatar",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getAvatar(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str.class))"),
            @Mapping(target = "carousel",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getCarousel(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str.class))"),
            @Mapping(target = "content",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getContent(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str.class))"),
            @Mapping(target = "sort",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getSort(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Lon.class))"),
            @Mapping(target = "indexFlag",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getIndexFlag(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Bool.class))"),
            @Mapping(target = "indexSort",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getIndexSort(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Lon.class))")
    })
    ExampleRespVO convert(ExampleDO bean);

    List<ExampleRespVO> convertList(List<ExampleDO> list);

    PageResult<ExampleRespVO> convertPage(PageResult<ExampleDO> page);

    List<ExampleExcelVO> convertList02(List<ExampleDO> list);

}
