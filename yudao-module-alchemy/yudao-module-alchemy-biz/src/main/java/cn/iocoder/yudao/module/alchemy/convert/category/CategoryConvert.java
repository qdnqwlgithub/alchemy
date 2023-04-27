package cn.iocoder.yudao.module.alchemy.convert.category;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
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

    CategoryDO convert(CategoryCreateReqVO bean);

    CategoryDO convert(CategoryUpdateReqVO bean);

    CategoryRespVO convert(CategoryDO bean);

    List<CategoryRespVO> convertList(List<CategoryDO> list);

    PageResult<CategoryRespVO> convertPage(PageResult<CategoryDO> page);

    List<CategoryExcelVO> convertList02(List<CategoryDO> list);

}
