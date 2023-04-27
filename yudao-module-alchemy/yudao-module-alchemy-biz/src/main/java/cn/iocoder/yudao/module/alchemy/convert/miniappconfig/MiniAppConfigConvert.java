package cn.iocoder.yudao.module.alchemy.convert.miniappconfig;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
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

    MiniAppConfigDO convert(MiniAppConfigCreateReqVO bean);

    MiniAppConfigDO convert(MiniAppConfigUpdateReqVO bean);

    MiniAppConfigRespVO convert(MiniAppConfigDO bean);

    List<MiniAppConfigRespVO> convertList(List<MiniAppConfigDO> list);

    PageResult<MiniAppConfigRespVO> convertPage(PageResult<MiniAppConfigDO> page);

    List<MiniAppConfigExcelVO> convertList02(List<MiniAppConfigDO> list);

}
