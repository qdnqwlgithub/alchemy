package cn.iocoder.yudao.module.alchemy.convert.cooperativepartner;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
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

    CooperativePartnerDO convert(CooperativePartnerCreateReqVO bean);

    CooperativePartnerDO convert(CooperativePartnerUpdateReqVO bean);

    CooperativePartnerRespVO convert(CooperativePartnerDO bean);

    List<CooperativePartnerRespVO> convertList(List<CooperativePartnerDO> list);

    PageResult<CooperativePartnerRespVO> convertPage(PageResult<CooperativePartnerDO> page);

    List<CooperativePartnerExcelVO> convertList02(List<CooperativePartnerDO> list);

}
