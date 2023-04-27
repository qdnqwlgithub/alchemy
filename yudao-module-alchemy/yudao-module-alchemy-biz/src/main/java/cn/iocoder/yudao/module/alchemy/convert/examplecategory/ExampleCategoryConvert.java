package cn.iocoder.yudao.module.alchemy.convert.examplecategory;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
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

    ExampleCategoryDO convert(ExampleCategoryCreateReqVO bean);

    ExampleCategoryDO convert(ExampleCategoryUpdateReqVO bean);

    ExampleCategoryRespVO convert(ExampleCategoryDO bean);

    List<ExampleCategoryRespVO> convertList(List<ExampleCategoryDO> list);

    PageResult<ExampleCategoryRespVO> convertPage(PageResult<ExampleCategoryDO> page);

    List<ExampleCategoryExcelVO> convertList02(List<ExampleCategoryDO> list);

}
