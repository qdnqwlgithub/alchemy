package cn.iocoder.yudao.module.alchemy.service.example;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.alchemy.controller.admin.example.vo.*;
import cn.iocoder.yudao.module.alchemy.dal.dataobject.example.ExampleDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.alchemy.convert.example.ExampleConvert;
import cn.iocoder.yudao.module.alchemy.dal.mysql.example.ExampleMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.alchemy.enums.ErrorCodeConstants.*;

/**
 * 案例 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ExampleServiceImpl implements ExampleService {

    @Resource
    private ExampleMapper exampleMapper;

    @Override
    public Long createExample(ExampleCreateReqVO createReqVO) {
        // 插入
        ExampleDO example = ExampleConvert.INSTANCE.convert(createReqVO);
        exampleMapper.insert(example);
        // 返回
        return example.getId();
    }

    @Override
    public void updateExample(ExampleUpdateReqVO updateReqVO) {
        // 校验存在
        validateExampleExists(updateReqVO.getId());
        // 更新
        ExampleDO updateObj = ExampleConvert.INSTANCE.convert(updateReqVO);
        exampleMapper.updateById(updateObj);
    }

    @Override
    public void deleteExample(Long id) {
        // 校验存在
        validateExampleExists(id);
        // 删除
        exampleMapper.deleteById(id);
    }

    private void validateExampleExists(Long id) {
        if (exampleMapper.selectById(id) == null) {
            throw exception(EXAMPLE_NOT_EXISTS);
        }
    }

    @Override
    public ExampleDO getExample(Long id) {
        return exampleMapper.selectById(id);
    }

    @Override
    public List<ExampleDO> getExampleList(Collection<Long> ids) {
        return exampleMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ExampleDO> getExamplePage(ExamplePageReqVO pageReqVO) {
        return exampleMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ExampleDO> getExampleList(ExampleExportReqVO exportReqVO) {
        return exampleMapper.selectList(exportReqVO);
    }

}
