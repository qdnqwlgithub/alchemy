package cn.iocoder.yudao.module.alchemy.convert.miniappconfig;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.alchemy.controller.admin.miniappconfig.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.miniappconfig.MiniAppConfigDO;

/**
 * 小程序配置 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface MiniAppConfigConvert {

    MiniAppConfigConvert INSTANCE = Mappers.getMapper(MiniAppConfigConvert.class);

    @Mappings({
            @Mapping(target = "headImg",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getHeadImg()))"),
            @Mapping(target = "carousel",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getCarousel()))"),
            @Mapping(target = "indexBottomImg",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getIndexBottomImg()))"),
            @Mapping(target = "companyName",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getCompanyName()))"),
            @Mapping(target = "address",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getAddress()))"),
            @Mapping(target = "phoneNumber",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getPhoneNumber()))"),
            @Mapping(target = "email",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getEmail()))"),
            @Mapping(target = "position",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getPosition()))"),
    })
    MiniAppConfigDO convert(MiniAppConfigCreateReqVO bean);

    @Mappings({
            @Mapping(target = "headImg",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getHeadImg()))"),
            @Mapping(target = "carousel",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getCarousel()))"),
            @Mapping(target = "indexBottomImg",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getIndexBottomImg()))"),
            @Mapping(target = "companyName",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getCompanyName()))"),
            @Mapping(target = "address",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getAddress()))"),
            @Mapping(target = "phoneNumber",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getPhoneNumber()))"),
            @Mapping(target = "email",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getEmail()))"),
            @Mapping(target = "position",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getPosition()))"),
    })
    MiniAppConfigDO convert(MiniAppConfigUpdateReqVO bean);

    @Mappings({
            @Mapping(target = "headImg",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getHeadImg(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str.class))"),
            @Mapping(target = "carousel",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getCarousel(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str.class))"),
            @Mapping(target = "indexBottomImg",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getIndexBottomImg(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str.class))"),
            @Mapping(target = "companyName",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getCompanyName(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str.class))"),
            @Mapping(target = "address",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getAddress(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str.class))"),
            @Mapping(target = "phoneNumber",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getPhoneNumber(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str.class))"),
            @Mapping(target = "email",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getEmail(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str.class))"),
            @Mapping(target = "position",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getPosition(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str.class))"),
    })
    MiniAppConfigRespVO convert(MiniAppConfigDO bean);

    List<MiniAppConfigRespVO> convertList(List<MiniAppConfigDO> list);

    PageResult<MiniAppConfigRespVO> convertPage(PageResult<MiniAppConfigDO> page);

    List<MiniAppConfigExcelVO> convertList02(List<MiniAppConfigDO> list);

}
