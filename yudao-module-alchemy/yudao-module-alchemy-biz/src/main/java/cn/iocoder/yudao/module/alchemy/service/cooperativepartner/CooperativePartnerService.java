package cn.iocoder.yudao.module.alchemy.service.cooperativepartner;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.alchemy.controller.admin.cooperativepartner.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.cooperativepartner.CooperativePartnerDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 合作伙伴 Service 接口
 *
 * @author 芋道源码
 */
public interface CooperativePartnerService {

    /**
     * 创建合作伙伴
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createCooperativePartner(@Valid CooperativePartnerCreateReqVO createReqVO);

    /**
     * 更新合作伙伴
     *
     * @param updateReqVO 更新信息
     */
    void updateCooperativePartner(@Valid CooperativePartnerUpdateReqVO updateReqVO);

    /**
     * 删除合作伙伴
     *
     * @param id 编号
     */
    void deleteCooperativePartner(Long id);

    /**
     * 获得合作伙伴
     *
     * @param id 编号
     * @return 合作伙伴
     */
    CooperativePartnerDO getCooperativePartner(Long id);

    /**
     * 获得合作伙伴列表
     *
     * @param ids 编号
     * @return 合作伙伴列表
     */
    List<CooperativePartnerDO> getCooperativePartnerList(Collection<Long> ids);

    /**
     * 获得合作伙伴分页
     *
     * @param pageReqVO 分页查询
     * @return 合作伙伴分页
     */
    PageResult<CooperativePartnerDO> getCooperativePartnerPage(CooperativePartnerPageReqVO pageReqVO);

    /**
     * 获得合作伙伴列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 合作伙伴列表
     */
    List<CooperativePartnerDO> getCooperativePartnerList(CooperativePartnerExportReqVO exportReqVO);

}
