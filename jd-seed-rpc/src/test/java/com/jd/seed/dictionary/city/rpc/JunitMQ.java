package com.jd.seed.dictionary.city.rpc;

import static org.springframework.util.Assert.isTrue;

import javax.annotation.Resource;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <pre>
 * 
 * 
 * </pre>
 * 
 * @author mecarlen 2018年12月25日 下午6:07:29
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
@SpringBootTest
public class JunitMQ {
	@Resource
	private DefaultMQProducer producer;
	@Test
	public void sendMessage() throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
		Message msg = new Message();
		String body = "hello RocketMQ";
		msg.setTopic("test001");
		msg.setTags("hello");
		msg.setBody(body.getBytes());
		msg.setKeys("hello");
		SendResult result = producer.send(msg);
		isTrue(result.isTraceOn(), "send message failure");
	}
	
	@Test
	public void consumerMessage() throws Exception{
		Thread.sleep(100000L);
		System.out.println("quit");
	}
}
