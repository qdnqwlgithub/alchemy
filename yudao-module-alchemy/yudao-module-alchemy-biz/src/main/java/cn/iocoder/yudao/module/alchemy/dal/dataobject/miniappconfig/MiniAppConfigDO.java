package cn.iocoder.yudao.module.alchemy.dal.dataobject.miniappconfig;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 小程序配置 DO
 *
 * @author 芋道源码
 */
@TableName("alchemy_mini_app_config")
@KeySequence("alchemy_mini_app_config_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MiniAppConfigDO extends BaseDO {

    /**
     * 小程序配置ID
     */
    @TableId
    private Long id;
    /**
     * 小程序顶部logo
     */
    private String headImg;
    /**
     * 首页轮播
     */
    private String carousel;
    /**
     * index页面底部图片
     */
    private String indexBottomImg;
    /**
     * 公司名
     */
    private String companyName;
    /**
     * 轮播图地址
     */
    private String address;
    /**
     * 电话号码
     */
    private String phoneNumber;
    /**
     * 邮箱地址
     */
    private String email;
    /**
     * 地图坐标
     */
    private String position;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 更新者
     */
    private String updateBy;

}
