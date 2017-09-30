package ssm.service.impl;

import org.apache.ibatis.executor.loader.ResultLoaderMap;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.session.Configuration;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import ssm.service.Greeting;

import java.util.List;
import java.util.Properties;

public class GreetingImpl implements Greeting {
    public void sayHello(String name) {
        System.out.println("Hello:"+name);
    }
    @Test
    public void client1() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());
        proxyFactory.addAdvice(new GreetingAroundAdvice());
        Greeting greeting =(Greeting)proxyFactory.getProxy();
        greeting.sayHello("Hello");
    }
}
