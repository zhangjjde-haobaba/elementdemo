package com.kgc.service.impl;

import com.kgc.entity.Test;
import com.kgc.mapper.TestMapper;
import com.kgc.service.TestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author Jiang Yiwei
 * @since 2022-02-22
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

}
