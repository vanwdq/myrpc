package com.wdq.inter.impl;

import com.wdq.inter.IHelloService;
import com.wdq.inter.rpc.RpcService;

@RpcService(IHelloService.class)
public class IHelloServiceImpl implements IHelloService {
    @Override
    public String hello(String name) {
        return name;
    }
}
