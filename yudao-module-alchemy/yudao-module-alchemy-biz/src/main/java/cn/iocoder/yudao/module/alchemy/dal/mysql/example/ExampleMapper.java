package cn.iocoder.yudao.module.alchemy.dal.mysql.example;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.example.ExampleDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.alchemy.controller.admin.example.vo.*;

/**
 * 案例 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ExampleMapper extends BaseMapperX<ExampleDO> {

    default PageResult<ExampleDO> selectPage(ExamplePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExampleDO>()
                .likeIfPresent(ExampleDO::getName, reqVO.getName())
                .eqIfPresent(ExampleDO::getCategoryId, reqVO.getCategoryId())
                .eqIfPresent(ExampleDO::getAvatar, reqVO.getAvatar())
                .eqIfPresent(ExampleDO::getCarousel, reqVO.getCarousel())
                .eqIfPresent(ExampleDO::getContent, reqVO.getContent())
                .eqIfPresent(ExampleDO::getSort, reqVO.getSort())
                .eqIfPresent(ExampleDO::getIndexFlag, reqVO.getIndexFlag())
                .eqIfPresent(ExampleDO::getCreateBy, reqVO.getCreateBy())
                .betweenIfPresent(ExampleDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ExampleDO::getUpdateBy, reqVO.getUpdateBy())
                .orderByDesc(ExampleDO::getId));
    }

    default List<ExampleDO> selectList(ExampleExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ExampleDO>()
                .likeIfPresent(ExampleDO::getName, reqVO.getName())
                .eqIfPresent(ExampleDO::getCategoryId, reqVO.getCategoryId())
                .eqIfPresent(ExampleDO::getAvatar, reqVO.getAvatar())
                .eqIfPresent(ExampleDO::getCarousel, reqVO.getCarousel())
                .eqIfPresent(ExampleDO::getContent, reqVO.getContent())
                .eqIfPresent(ExampleDO::getSort, reqVO.getSort())
                .eqIfPresent(ExampleDO::getIndexFlag, reqVO.getIndexFlag())
                .eqIfPresent(ExampleDO::getCreateBy, reqVO.getCreateBy())
                .betweenIfPresent(ExampleDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ExampleDO::getUpdateBy, reqVO.getUpdateBy())
                .orderByDesc(ExampleDO::getId));
    }

}
