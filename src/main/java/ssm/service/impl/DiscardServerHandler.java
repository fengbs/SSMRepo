package ssm.service.impl;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg ) {
        ByteBuf in = (ByteBuf) msg;

        try {
            System.out.println(in.toString(CharsetUtil.UTF_8));
            /*while (in.isReadable()) { // (1)
                //System.out.print((char) in.readByte());
                System.out.println(in.readByte().toString(CharsetUtil.UTF_8));
                System.out.flush();
            }*/
        } finally {
            ReferenceCountUtil.release(msg); // (2)
        }

        ctx.write(msg);
        ctx.flush();

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx , Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
