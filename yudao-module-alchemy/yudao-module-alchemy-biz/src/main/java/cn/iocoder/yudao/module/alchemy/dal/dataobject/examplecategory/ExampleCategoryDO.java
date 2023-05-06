package cn.iocoder.yudao.module.alchemy.dal.dataobject.examplecategory;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 案例分类 DO
 *
 * @author 芋道源码
 */
@TableName("alchemy_example_category")
@KeySequence("alchemy_example_category_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExampleCategoryDO extends BaseDO {

    /**
     * 案例分类ID
     */
    @TableId
    private Long id;
    /**
     * 案例分类名称
     */
    private String name;
    /**
     * 显示顺序
     */
    private String sort;

}
