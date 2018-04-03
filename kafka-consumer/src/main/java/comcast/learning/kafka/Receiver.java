package comcast.learning.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Receiver {
	
	private String content;

    private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);

    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void listen(@Payload String message) {
        LOG.info("received message='{}'", message);
        this.content=message;
        
    }
	
    
    @RequestMapping(value="/")
    public String display() {
    	
    	return content;
    }
    
    
}