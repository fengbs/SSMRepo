package ssm.service.impl;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

public class TimeClientHandler extends ChannelInboundHandlerAdapter {
    private ByteBuf buf;
    public void channelRead(ChannelHandlerContext ctx , Object msg ) {
        ByteBuf m = (ByteBuf)msg;
        buf.writeBytes(m);
        m.release();

        if ( buf.readableBytes() >= 4 ) {
            long currentTimeMillis = (m.readUnsignedInt() - 2208988800L)*1000L;
            System.out.println(new Date(currentTimeMillis));
            ctx.close();
        }
        /*try {
            long currentTimeMillis = (m.readUnsignedInt() - 2208988800L)*1000L;
            System.out.println(new Date(currentTimeMillis));
            ctx.close();
        } finally {
            m.release();
        }*/
    }

    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        buf = ctx.alloc().buffer(4);
    }

    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        buf.release();
        buf = null;
    }

    public void exceptionCaught( ChannelHandlerContext ctx , Throwable cause ) {
        cause.printStackTrace();
        ctx.close();
    }
}
