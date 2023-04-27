package cn.iocoder.yudao.module.alchemy.service.miniappconfig;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.alchemy.controller.admin.miniappconfig.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.miniappconfig.MiniAppConfigDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.alchemy.convert.miniappconfig.MiniAppConfigConvert;
import cn.iocoder.yudao.module.alchemy.dal.mysql.miniappconfig.MiniAppConfigMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.alchemy.enums.ErrorCodeConstants.*;

/**
 * 小程序配置 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class MiniAppConfigServiceImpl implements MiniAppConfigService {

    @Resource
    private MiniAppConfigMapper miniAppConfigMapper;

    @Override
    public Long createMiniAppConfig(MiniAppConfigCreateReqVO createReqVO) {
        // 插入
        MiniAppConfigDO miniAppConfig = MiniAppConfigConvert.INSTANCE.convert(createReqVO);
        miniAppConfigMapper.insert(miniAppConfig);
        // 返回
        return miniAppConfig.getId();
    }

    @Override
    public void updateMiniAppConfig(MiniAppConfigUpdateReqVO updateReqVO) {
        // 校验存在
        validateMiniAppConfigExists(updateReqVO.getId());
        // 更新
        MiniAppConfigDO updateObj = MiniAppConfigConvert.INSTANCE.convert(updateReqVO);
        miniAppConfigMapper.updateById(updateObj);
    }

    @Override
    public void deleteMiniAppConfig(Long id) {
        // 校验存在
        validateMiniAppConfigExists(id);
        // 删除
        miniAppConfigMapper.deleteById(id);
    }

    private void validateMiniAppConfigExists(Long id) {
        if (miniAppConfigMapper.selectById(id) == null) {
            throw exception(MINI_APP_CONFIG_NOT_EXISTS);
        }
    }

    @Override
    public MiniAppConfigDO getMiniAppConfig(Long id) {
        return miniAppConfigMapper.selectById(id);
    }

    @Override
    public List<MiniAppConfigDO> getMiniAppConfigList(Collection<Long> ids) {
        return miniAppConfigMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MiniAppConfigDO> getMiniAppConfigPage(MiniAppConfigPageReqVO pageReqVO) {
        return miniAppConfigMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MiniAppConfigDO> getMiniAppConfigList(MiniAppConfigExportReqVO exportReqVO) {
        return miniAppConfigMapper.selectList(exportReqVO);
    }

}
