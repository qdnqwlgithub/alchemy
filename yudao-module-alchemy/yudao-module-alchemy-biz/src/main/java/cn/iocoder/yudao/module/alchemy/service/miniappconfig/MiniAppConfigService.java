package cn.iocoder.yudao.module.alchemy.service.miniappconfig;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.alchemy.controller.admin.miniappconfig.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.miniappconfig.MiniAppConfigDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 小程序配置 Service 接口
 *
 * @author 芋道源码
 */
public interface MiniAppConfigService {

    /**
     * 创建小程序配置
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createMiniAppConfig(@Valid MiniAppConfigCreateReqVO createReqVO);

    /**
     * 更新小程序配置
     *
     * @param updateReqVO 更新信息
     */
    void updateMiniAppConfig(@Valid MiniAppConfigUpdateReqVO updateReqVO);

    /**
     * 删除小程序配置
     *
     * @param id 编号
     */
    void deleteMiniAppConfig(Long id);

    /**
     * 获得小程序配置
     *
     * @param id 编号
     * @return 小程序配置
     */
    MiniAppConfigDO getMiniAppConfig(Long id);

    /**
     * 获得小程序配置列表
     *
     * @param ids 编号
     * @return 小程序配置列表
     */
    List<MiniAppConfigDO> getMiniAppConfigList(Collection<Long> ids);

    /**
     * 获得小程序配置分页
     *
     * @param pageReqVO 分页查询
     * @return 小程序配置分页
     */
    PageResult<MiniAppConfigDO> getMiniAppConfigPage(MiniAppConfigPageReqVO pageReqVO);

    /**
     * 获得小程序配置列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 小程序配置列表
     */
    List<MiniAppConfigDO> getMiniAppConfigList(MiniAppConfigExportReqVO exportReqVO);

}
