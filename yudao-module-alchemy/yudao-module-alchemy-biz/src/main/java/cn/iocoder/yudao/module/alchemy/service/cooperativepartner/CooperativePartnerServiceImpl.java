package cn.iocoder.yudao.module.alchemy.service.cooperativepartner;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.alchemy.controller.admin.cooperativepartner.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.cooperativepartner.CooperativePartnerDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.alchemy.convert.cooperativepartner.CooperativePartnerConvert;
import cn.iocoder.yudao.module.alchemy.dal.mysql.cooperativepartner.CooperativePartnerMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.alchemy.enums.ErrorCodeConstants.*;

/**
 * 合作伙伴 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class CooperativePartnerServiceImpl implements CooperativePartnerService {

    @Resource
    private CooperativePartnerMapper cooperativePartnerMapper;

    @Override
    public Long createCooperativePartner(CooperativePartnerCreateReqVO createReqVO) {
        // 插入
        CooperativePartnerDO cooperativePartner = CooperativePartnerConvert.INSTANCE.convert(createReqVO);
        cooperativePartnerMapper.insert(cooperativePartner);
        // 返回
        return cooperativePartner.getId();
    }

    @Override
    public void updateCooperativePartner(CooperativePartnerUpdateReqVO updateReqVO) {
        // 校验存在
        validateCooperativePartnerExists(updateReqVO.getId());
        // 更新
        CooperativePartnerDO updateObj = CooperativePartnerConvert.INSTANCE.convert(updateReqVO);
        cooperativePartnerMapper.updateById(updateObj);
    }

    @Override
    public void deleteCooperativePartner(Long id) {
        // 校验存在
        validateCooperativePartnerExists(id);
        // 删除
        cooperativePartnerMapper.deleteById(id);
    }

    private void validateCooperativePartnerExists(Long id) {
        if (cooperativePartnerMapper.selectById(id) == null) {
            throw exception(COOPERATIVE_PARTNER_NOT_EXISTS);
        }
    }

    @Override
    public CooperativePartnerDO getCooperativePartner(Long id) {
        return cooperativePartnerMapper.selectById(id);
    }

    @Override
    public List<CooperativePartnerDO> getCooperativePartnerList(Collection<Long> ids) {
        return cooperativePartnerMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<CooperativePartnerDO> getCooperativePartnerPage(CooperativePartnerPageReqVO pageReqVO) {
        return cooperativePartnerMapper.selectPage(pageReqVO);
    }

    @Override
    public List<CooperativePartnerDO> getCooperativePartnerList(CooperativePartnerExportReqVO exportReqVO) {
        return cooperativePartnerMapper.selectList(exportReqVO);
    }

}
