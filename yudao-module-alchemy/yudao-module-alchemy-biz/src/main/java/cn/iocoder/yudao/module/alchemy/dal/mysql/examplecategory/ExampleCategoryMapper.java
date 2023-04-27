package cn.iocoder.yudao.module.alchemy.dal.mysql.examplecategory;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.examplecategory.ExampleCategoryDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.alchemy.controller.admin.examplecategory.vo.*;

/**
 * 案例分类 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ExampleCategoryMapper extends BaseMapperX<ExampleCategoryDO> {

    default PageResult<ExampleCategoryDO> selectPage(ExampleCategoryPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExampleCategoryDO>()
                .likeIfPresent(ExampleCategoryDO::getName, reqVO.getName())
                .eqIfPresent(ExampleCategoryDO::getSort, reqVO.getSort())
                .eqIfPresent(ExampleCategoryDO::getCreateBy, reqVO.getCreateBy())
                .betweenIfPresent(ExampleCategoryDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ExampleCategoryDO::getUpdateBy, reqVO.getUpdateBy())
                .orderByDesc(ExampleCategoryDO::getId));
    }

    default List<ExampleCategoryDO> selectList(ExampleCategoryExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ExampleCategoryDO>()
                .likeIfPresent(ExampleCategoryDO::getName, reqVO.getName())
                .eqIfPresent(ExampleCategoryDO::getSort, reqVO.getSort())
                .eqIfPresent(ExampleCategoryDO::getCreateBy, reqVO.getCreateBy())
                .betweenIfPresent(ExampleCategoryDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ExampleCategoryDO::getUpdateBy, reqVO.getUpdateBy())
                .orderByDesc(ExampleCategoryDO::getId));
    }

}
