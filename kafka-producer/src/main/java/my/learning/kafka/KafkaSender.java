package my.learning.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import my.learning.model.Product;

@Service
public class KafkaSender {

	
	@Autowired
	private KafkaTemplate<String,Product> kafkaTemplate;

	
	@Value("${spring.kafka.template.default-topic}")
	String kafkaTopic;
	
	@Value("${kafka.header.partition.value}")
	Integer partition;
	
	@Value("${kafka.header.messageKey.value}")
	Integer messagekey;
	
	
	
	 private static final Logger log = LoggerFactory.getLogger(KafkaSender.class);
	 
	public void send(Product product) {
	    
		log.info("sending message='{}' to topic='{}'", product.toString(), "product-topics");
	
	
	log.info("partition='{}'  and messageKey = '{}'", partition, messagekey);
	
	    
	//kafkaTemplate.send(kafkaTopic,product);
	
	  Message<Product> message= MessageBuilder.withPayload(product).setHeader(KafkaHeaders.TOPIC,kafkaTopic).setHeader(KafkaHeaders.PARTITION_ID, partition).setHeader(KafkaHeaders.MESSAGE_KEY, messagekey).build();
	
	  
	  kafkaTemplate.send(message);
	}
	
}
