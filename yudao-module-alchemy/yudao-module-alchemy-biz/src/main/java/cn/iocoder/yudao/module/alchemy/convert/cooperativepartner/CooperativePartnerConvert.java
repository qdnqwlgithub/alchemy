package cn.iocoder.yudao.module.alchemy.convert.cooperativepartner;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.alchemy.controller.admin.cooperativepartner.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.cooperativepartner.CooperativePartnerDO;

/**
 * 合作伙伴 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface CooperativePartnerConvert {

    CooperativePartnerConvert INSTANCE = Mappers.getMapper(CooperativePartnerConvert.class);

    @Mappings({
            @Mapping(target = "name",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getName()))"),
            @Mapping(target = "avatar",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getAvatar()))"),
            @Mapping(target = "sort",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getSort()))")
    })
    CooperativePartnerDO convert(CooperativePartnerCreateReqVO bean);

    @Mappings({
            @Mapping(target = "name",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getName()))"),
            @Mapping(target = "avatar",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getAvatar()))"),
            @Mapping(target = "sort",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getSort()))")
    })
    CooperativePartnerDO convert(CooperativePartnerUpdateReqVO bean);

    @Mappings({
            @Mapping(target = "name",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getName(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str.class))"),
            @Mapping(target = "avatar",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getAvatar(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str.class))"),
            @Mapping(target = "sort",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getSort(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Lon.class))")
    })
    CooperativePartnerRespVO convert(CooperativePartnerDO bean);

    List<CooperativePartnerRespVO> convertList(List<CooperativePartnerDO> list);

    PageResult<CooperativePartnerRespVO> convertPage(PageResult<CooperativePartnerDO> page);

    List<CooperativePartnerExcelVO> convertList02(List<CooperativePartnerDO> list);

}
