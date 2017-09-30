package ssm.service.impl;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import org.springframework.util.SerializationUtils;
import ssm.service.EndPoint;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class QueueConsumer extends EndPoint implements Runnable,Consumer {
    public QueueConsumer ( String endPointName ) throws IOException, TimeoutException {
        super(endPointName);
    }
    public void handleConsumeOk(String s) {
        try {
            channel.basicConsume(endPointName,true,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleCancelOk(String s) {
        System.out.println("Consumer " + s + " registered");
    }

    public void handleCancel(String s) throws IOException {

    }

    public void handleShutdownSignal(String s, ShutdownSignalException e) {

    }

    public void handleRecoverOk(String s) {

    }

    public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {
        Map mp = (HashMap) SerializationUtils.deserialize(bytes);
        System.out.println("Message Number " + mp.get("message number") + " received" );
    }

    public void run() {

    }
}
