package my.learning.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.learning.model.Product;



@RestController
public class Receiver {
	
	private  Product product=new Product();

    private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);

    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void listen(Product message, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) Integer messageKey, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        LOG.info("Message Received='{}'  at topic ='{}' and Partition ID ='{}'", message,topic, partitionId );
        this.product=message;
        
    }
	
    
    @RequestMapping(value="/")
    public Product display() {
    	
    	return product;
    }
    
    
}