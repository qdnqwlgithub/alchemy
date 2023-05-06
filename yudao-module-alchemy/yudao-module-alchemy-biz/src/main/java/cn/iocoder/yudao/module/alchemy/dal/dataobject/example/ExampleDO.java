package cn.iocoder.yudao.module.alchemy.dal.dataobject.example;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 案例 DO
 *
 * @author 芋道源码
 */
@TableName("alchemy_example")
@KeySequence("alchemy_example_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExampleDO extends BaseDO {

    /**
     * 案例ID
     */
    @TableId
    private Long id;
    /**
     * 案例名称
     */
    private String name;
    /**
     * 所属分类
     */
    private Integer categoryId;
    /**
     * 封面图
     */
    private String avatar;
    /**
     * 轮播图地址
     */
    private String carousel;
    /**
     * 案例详情
     */
    private String content;
    /**
     * 显示顺序
     */
    private String sort;
    /**
     * 是否展示到首页
     */
    private String indexFlag;
    /**
     * index排序
     */
    private String indexSort;

}
