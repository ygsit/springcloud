package com.yu.springcloud.handle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yu.springcloud.entity.CommonResult;

/**
 * 自定义限流处理类
 */
public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(2020, "自定义限流处理信息....CustomerBlockHandler");
    }
}