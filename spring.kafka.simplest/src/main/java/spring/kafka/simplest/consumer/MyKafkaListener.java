package spring.kafka.simplest.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MyKafkaListener {

	@Autowired
	private MyMessagePublisher myMessagePublisher;

	@KafkaListener(topics = "test")
	public void receiveMessage(String message) {
		myMessagePublisher.send(message);
	}

}
