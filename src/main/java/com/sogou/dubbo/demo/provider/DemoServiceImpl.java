package com.sogou.dubbo.demo.provider;

import com.sogou.dubbo.demo.DemoService;

public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}