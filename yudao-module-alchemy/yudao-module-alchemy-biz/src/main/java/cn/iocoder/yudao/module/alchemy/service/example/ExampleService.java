package cn.iocoder.yudao.module.alchemy.service.example;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.alchemy.controller.admin.example.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.example.ExampleDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 案例 Service 接口
 *
 * @author 芋道源码
 */
public interface ExampleService {

    /**
     * 创建案例
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExample(@Valid ExampleCreateReqVO createReqVO);

    /**
     * 更新案例
     *
     * @param updateReqVO 更新信息
     */
    void updateExample(@Valid ExampleUpdateReqVO updateReqVO);

    /**
     * 删除案例
     *
     * @param id 编号
     */
    void deleteExample(Long id);

    /**
     * 获得案例
     *
     * @param id 编号
     * @return 案例
     */
    ExampleDO getExample(Long id);

    /**
     * 获得案例列表
     *
     * @param ids 编号
     * @return 案例列表
     */
    List<ExampleDO> getExampleList(Collection<Long> ids);

    /**
     * 获得案例分页
     *
     * @param pageReqVO 分页查询
     * @return 案例分页
     */
    PageResult<ExampleDO> getExamplePage(ExamplePageReqVO pageReqVO);

    /**
     * 获得案例列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 案例列表
     */
    List<ExampleDO> getExampleList(ExampleExportReqVO exportReqVO);

}
