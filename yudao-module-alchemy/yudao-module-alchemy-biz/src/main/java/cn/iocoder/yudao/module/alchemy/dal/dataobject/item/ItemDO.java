package cn.iocoder.yudao.module.alchemy.dal.dataobject.item;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 元素 DO
 *
 * @author 芋道源码
 */
@TableName("alchemy_item")
@KeySequence("alchemy_item_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDO extends BaseDO {

    /**
     * 元素ID
     */
    @TableId
    private Long id;
    /**
     * 元素名称
     */
    private String name;
    /**
     * 元素简介
     */
    private String intro;
    /**
     * 所属分类id
     */
    private Long cId;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 轮播图地址
     */
    private String carousel;
    /**
     * 元素详情
     */
    private String content;
    /**
     * 产品手册
     */
    private String doc;
    /**
     * 浏览量
     */
    private Long viewNum;
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
