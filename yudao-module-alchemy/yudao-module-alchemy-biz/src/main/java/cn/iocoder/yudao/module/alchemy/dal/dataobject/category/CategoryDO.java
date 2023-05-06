package cn.iocoder.yudao.module.alchemy.dal.dataobject.category;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 分类 DO
 *
 * @author 芋道源码
 */
@TableName("alchemy_category")
@KeySequence("alchemy_category_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDO extends BaseDO {

    /**
     * 分类id
     */
    @TableId
    private Long id;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 父分类id
     */
    private Long parentId;
    /**
     * 浏览量
     */
    private String viewNum;
    /**
     * 显示顺序
     */
    private String sort;

}
