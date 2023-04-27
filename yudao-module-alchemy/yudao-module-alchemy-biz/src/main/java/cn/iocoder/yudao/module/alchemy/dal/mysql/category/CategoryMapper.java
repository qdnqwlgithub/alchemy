package cn.iocoder.yudao.module.alchemy.dal.mysql.category;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.category.CategoryDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.alchemy.controller.admin.category.vo.*;

/**
 * 分类 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface CategoryMapper extends BaseMapperX<CategoryDO> {

    default PageResult<CategoryDO> selectPage(CategoryPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CategoryDO>()
                .likeIfPresent(CategoryDO::getName, reqVO.getName())
                .eqIfPresent(CategoryDO::getAvatar, reqVO.getAvatar())
                .eqIfPresent(CategoryDO::getParentId, reqVO.getParentId())
                .eqIfPresent(CategoryDO::getViewNum, reqVO.getViewNum())
                .eqIfPresent(CategoryDO::getSort, reqVO.getSort())
                .betweenIfPresent(CategoryDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(CategoryDO::getId));
    }

    default List<CategoryDO> selectList(CategoryExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<CategoryDO>()
                .likeIfPresent(CategoryDO::getName, reqVO.getName())
                .eqIfPresent(CategoryDO::getAvatar, reqVO.getAvatar())
                .eqIfPresent(CategoryDO::getParentId, reqVO.getParentId())
                .eqIfPresent(CategoryDO::getViewNum, reqVO.getViewNum())
                .eqIfPresent(CategoryDO::getSort, reqVO.getSort())
                .betweenIfPresent(CategoryDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(CategoryDO::getId));
    }

}
