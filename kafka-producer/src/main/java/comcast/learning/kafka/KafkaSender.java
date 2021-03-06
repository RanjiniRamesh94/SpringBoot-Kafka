package comcast.learning.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {

	
	@Autowired
	private KafkaTemplate kafkaTemplate;
	
	
	  public KafkaSender(KafkaTemplate kafkaTemplate){
	        this.kafkaTemplate=kafkaTemplate;
	    }
	
	@Value("${spring.kafka.template.default-topic}")
	String kafkaTopic;

	 private static final Logger lOG = LoggerFactory.getLogger(KafkaSender.class);
	 
	public void send(String message) {
	    
	lOG.info("sending message='{}' to topic='{}'", message, "product-topics");
	
	    
	kafkaTemplate.send(kafkaTopic,message);
	
	   
	
	}
	
}
