package cn.iocoder.yudao.module.alchemy.dal.dataobject.cooperativepartner;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 合作伙伴 DO
 *
 * @author 芋道源码
 */
@TableName("alchemy_cooperative_partner")
@KeySequence("alchemy_cooperative_partner_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CooperativePartnerDO extends BaseDO {

    /**
     * 合作伙伴ID
     */
    @TableId
    private Long id;
    /**
     * 合作伙伴名称
     */
    private String name;
    /**
     * 封面图
     */
    private String avatar;
    /**
     * 显示顺序
     */
    private String sort;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 更新者
     */
    private String updateBy;

}
