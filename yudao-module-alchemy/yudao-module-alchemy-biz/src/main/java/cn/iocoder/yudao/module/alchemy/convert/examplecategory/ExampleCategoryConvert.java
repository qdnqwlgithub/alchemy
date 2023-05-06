package cn.iocoder.yudao.module.alchemy.convert.examplecategory;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.alchemy.controller.admin.examplecategory.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.examplecategory.ExampleCategoryDO;

/**
 * 案例分类 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ExampleCategoryConvert {

    ExampleCategoryConvert INSTANCE = Mappers.getMapper(ExampleCategoryConvert.class);

    @Mappings({
            @Mapping(target = "name",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getName()))"),
            @Mapping(target = "sort",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getSort()))")
    })
    ExampleCategoryDO convert(ExampleCategoryCreateReqVO bean);

    @Mappings({
            @Mapping(target = "name",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getName()))"),
            @Mapping(target = "sort",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getSort()))")
    })
    ExampleCategoryDO convert(ExampleCategoryUpdateReqVO bean);

    @Mappings({
            @Mapping(target = "name",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getName(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str.class))"),
            @Mapping(target = "sort",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getSort(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Lon.class))")
    })
    ExampleCategoryRespVO convert(ExampleCategoryDO bean);

    List<ExampleCategoryRespVO> convertList(List<ExampleCategoryDO> list);

    PageResult<ExampleCategoryRespVO> convertPage(PageResult<ExampleCategoryDO> page);

    List<ExampleCategoryExcelVO> convertList02(List<ExampleCategoryDO> list);

}
