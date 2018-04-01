package comcast.learning.kafka;

import org.springframework.kafka.annotation.KafkaListener;

import comcast.learning.model.Consumer;

public class ConsumerApp {

	 @KafkaListener(topics="${jsa.kafka.topic}")
	    public void processMessage(String content) {
			
			Consumer abc=new Consumer();
			
			abc.setContent(content);
	    }
	
}
