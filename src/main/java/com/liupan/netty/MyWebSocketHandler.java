package com.liupan.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MyWebSocketHandler extends SimpleChannelInboundHandler<Object> {

	@Override
	protected void messageReceived(ChannelHandlerContext arg0, Object arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
//		// TODO Auto-generated method stub
//		super.channelActive(ctx);
		NettyConfig.group.add(ctx.channel());
		System.out.println("客户端与服务端连接已经开启");
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//		// TODO Auto-generated method stub
//		super.channelInactive(ctx);
		NettyConfig.group.remove(ctx.channel());
		System.out.println("客户端与服务端连接已经断开");
	}
	//服务端接收客户端发送过来的数据结束后调用
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//		// TODO Auto-generated method stub
//		super.channelReadComplete(ctx);
		ctx.flush();
		System.out.println("客户端与服务端读取完成");
		
		
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//		// TODO Auto-generated method stub
//		super.exceptionCaught(ctx, cause);
		cause.printStackTrace();
		ctx.close();
		System.out.println("客户端与服务端出现异常");
		
	}

	
	
}
