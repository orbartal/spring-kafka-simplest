package spring.kafka.simplest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import spring.kafka.simplest.consumer.MyMessagePublisher;
import spring.kafka.simplest.producer.MyKafkaSender;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MainKafkaSpringSimplestTests {

	private static final String TOPIC = "test";

	@Autowired
	private MyMessagePublisher myMessagePublisher;

    @Autowired
    private MyKafkaSender sender;

    @Test
    public void test1() throws Exception {
    	MySubscriber<String> subscriber = new MySubscriber<>();
    	myMessagePublisher.addSubscriber(subscriber);

	    List<String> items = List.of("a1", "b2", "c3");
	    items.forEach(i->sender.sendMessage(TOPIC, i));

	    Thread.sleep(2000);
	    Assert.assertTrue(subscriber.consumedElements.containsAll(items));
	    Assert.assertTrue(items.containsAll(subscriber.consumedElements));
    }
}
