package ssm.service.impl;

import org.springframework.util.SerializationUtils;
import ssm.service.EndPoint;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;

public class Producer extends EndPoint {
    public Producer ( String endPointName) throws IOException, TimeoutException {
        super(endPointName);
    }
    public void sendMessage(Serializable object) throws IOException {
        channel.basicPublish("",endPointName,null, SerializationUtils.serialize(object));
    }
}
