package cn.iocoder.yudao.module.alchemy.dal.mysql.miniappconfig;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.miniappconfig.MiniAppConfigDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.alchemy.controller.admin.miniappconfig.vo.*;

/**
 * 小程序配置 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface MiniAppConfigMapper extends BaseMapperX<MiniAppConfigDO> {

    default PageResult<MiniAppConfigDO> selectPage(MiniAppConfigPageReqVO reqVO) {
//        return selectPage(reqVO, new LambdaQueryWrapperX<MiniAppConfigDO>()
//                .eqIfPresent(MiniAppConfigDO::getHeadImg, reqVO.getHeadImg())
//                .eqIfPresent(MiniAppConfigDO::getCarousel, reqVO.getCarousel())
//                .eqIfPresent(MiniAppConfigDO::getIndexBottomImg, reqVO.getIndexBottomImg())
//                .likeIfPresent(MiniAppConfigDO::getCompanyName, reqVO.getCompanyName())
//                .eqIfPresent(MiniAppConfigDO::getAddress, reqVO.getAddress())
//                .eqIfPresent(MiniAppConfigDO::getPhoneNumber, reqVO.getPhoneNumber())
//                .eqIfPresent(MiniAppConfigDO::getEmail, reqVO.getEmail())
//                .eqIfPresent(MiniAppConfigDO::getPosition, reqVO.getPosition())
//                .betweenIfPresent(MiniAppConfigDO::getCreateTime, reqVO.getCreateTime())
//                .orderByDesc(MiniAppConfigDO::getId));
        return selectPage(reqVO, null);
    }

    default List<MiniAppConfigDO> selectList(MiniAppConfigExportReqVO reqVO) {
//        return selectList(new LambdaQueryWrapperX<MiniAppConfigDO>()
//                .eqIfPresent(MiniAppConfigDO::getHeadImg, reqVO.getHeadImg())
//                .eqIfPresent(MiniAppConfigDO::getCarousel, reqVO.getCarousel())
//                .eqIfPresent(MiniAppConfigDO::getIndexBottomImg, reqVO.getIndexBottomImg())
//                .likeIfPresent(MiniAppConfigDO::getCompanyName, reqVO.getCompanyName())
//                .eqIfPresent(MiniAppConfigDO::getAddress, reqVO.getAddress())
//                .eqIfPresent(MiniAppConfigDO::getPhoneNumber, reqVO.getPhoneNumber())
//                .eqIfPresent(MiniAppConfigDO::getEmail, reqVO.getEmail())
//                .eqIfPresent(MiniAppConfigDO::getPosition, reqVO.getPosition())
//                .betweenIfPresent(MiniAppConfigDO::getCreateTime, reqVO.getCreateTime())
//                .orderByDesc(MiniAppConfigDO::getId));
        return selectList();
    }

}
