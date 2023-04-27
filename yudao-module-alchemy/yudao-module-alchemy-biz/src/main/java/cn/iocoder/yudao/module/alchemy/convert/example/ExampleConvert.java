package cn.iocoder.yudao.module.alchemy.convert.example;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
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

    ExampleDO convert(ExampleCreateReqVO bean);

    ExampleDO convert(ExampleUpdateReqVO bean);

    ExampleRespVO convert(ExampleDO bean);

    List<ExampleRespVO> convertList(List<ExampleDO> list);

    PageResult<ExampleRespVO> convertPage(PageResult<ExampleDO> page);

    List<ExampleExcelVO> convertList02(List<ExampleDO> list);

}
