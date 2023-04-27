package cn.iocoder.yudao.module.alchemy.dal.mysql.cooperativepartner;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.cooperativepartner.CooperativePartnerDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.alchemy.controller.admin.cooperativepartner.vo.*;

/**
 * 合作伙伴 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface CooperativePartnerMapper extends BaseMapperX<CooperativePartnerDO> {

    default PageResult<CooperativePartnerDO> selectPage(CooperativePartnerPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CooperativePartnerDO>()
                .likeIfPresent(CooperativePartnerDO::getName, reqVO.getName())
                .eqIfPresent(CooperativePartnerDO::getAvatar, reqVO.getAvatar())
                .eqIfPresent(CooperativePartnerDO::getSort, reqVO.getSort())
                .eqIfPresent(CooperativePartnerDO::getCreateBy, reqVO.getCreateBy())
                .betweenIfPresent(CooperativePartnerDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(CooperativePartnerDO::getUpdateBy, reqVO.getUpdateBy())
                .orderByDesc(CooperativePartnerDO::getId));
    }

    default List<CooperativePartnerDO> selectList(CooperativePartnerExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<CooperativePartnerDO>()
                .likeIfPresent(CooperativePartnerDO::getName, reqVO.getName())
                .eqIfPresent(CooperativePartnerDO::getAvatar, reqVO.getAvatar())
                .eqIfPresent(CooperativePartnerDO::getSort, reqVO.getSort())
                .eqIfPresent(CooperativePartnerDO::getCreateBy, reqVO.getCreateBy())
                .betweenIfPresent(CooperativePartnerDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(CooperativePartnerDO::getUpdateBy, reqVO.getUpdateBy())
                .orderByDesc(CooperativePartnerDO::getId));
    }

}
