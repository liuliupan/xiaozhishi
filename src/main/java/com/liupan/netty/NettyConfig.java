package com.liupan.netty;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.GlobalEventExecutor;

public class NettyConfig {
	//接入时的全局配置量
	public static ChannelGroup group=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	
}
