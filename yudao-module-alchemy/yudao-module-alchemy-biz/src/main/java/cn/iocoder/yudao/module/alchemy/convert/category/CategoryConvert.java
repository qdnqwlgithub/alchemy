package cn.iocoder.yudao.module.alchemy.convert.category;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.category.CategoryDO;

/**
 * 分类 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface CategoryConvert {

    CategoryConvert INSTANCE = Mappers.getMapper(CategoryConvert.class);

    @Mappings({
            @Mapping(target = "name",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getName()))"),
            @Mapping(target = "avatar",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getAvatar()))"),
            @Mapping(target = "sort",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getSort()))"),
            @Mapping(target = "viewNum",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getViewNum()))")
    })
    CategoryDO convert(CategoryCreateReqVO bean);


    @Mappings({
            @Mapping(target = "name",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getName()))"),
            @Mapping(target = "avatar",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getAvatar()))"),
            @Mapping(target = "sort",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getSort()))"),
            @Mapping(target = "viewNum",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getViewNum()))")
    })
    CategoryDO convert(CategoryUpdateReqVO bean);


    @Mappings({
            @Mapping(target = "name",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getName(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str.class))"),
            @Mapping(target = "avatar",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getAvatar(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str.class))"),
            @Mapping(target = "sort",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getSort(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Lon.class))"),
            @Mapping(target = "viewNum",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(bean.getViewNum(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Lon.class))")
    })
    CategoryRespVO convert(CategoryDO bean);

//    @Mappings({
//            @Mapping(target = "name",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getName()))"),
//            @Mapping(target = "avatar",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getAvatar()))"),
//            @Mapping(target = "sort",expression = "java(cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getSort()))")
//    })
    List<CategoryRespVO> convertList(List<CategoryDO> list);

//    @Mappings({
//            @Mapping(target = "list",expression = "java(page.getList().stream().map(this::convert).collect(java.util.stream.Collectors.toList()))"),
//    })
    PageResult<CategoryRespVO> convertPage(PageResult<CategoryDO> page);

    List<CategoryExcelVO> convertList02(List<CategoryDO> list);

//    @AfterMapping
//    @BeforeMapping
//    default void convertAfter(CategoryDO categoryDO,@MappingTarget CategoryRespVO categoryRespVO){
//        System.out.println(123);
//        categoryRespVO.setName(cn.iocoder.yudao.framework.common.util.json.JsonUtils.parseObject(categoryDO.getName(),cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.I18Str.class));
//    }

}
