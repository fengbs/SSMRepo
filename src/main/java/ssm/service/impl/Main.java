package ssm.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

public class Main  {
    public Main() throws IOException, TimeoutException {
        QueueConsumer consumer = new QueueConsumer("queue");
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
        Producer producer = new Producer("queue");
        for ( int i = 0 ; i < 100000 ; ++i ) {
            HashMap message = new HashMap();
            message.put("message number" , i );
            producer.sendMessage(message);
            System.out.println("Message Number " + i + " sent.");
        }
    }

    public static void main ( String [] args ) throws IOException, TimeoutException {
        new Main();
    }
}
