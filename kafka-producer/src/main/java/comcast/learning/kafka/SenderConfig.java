package comcast.learning.kafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SenderConfig {

	@Autowired
	KafkaProperties kafkaProperties;

	/*
	 * @Value("${spring.kafka.bootstrap-servers}") private String bootstrapServers;
	 */

	 @Bean
     public ProducerFactory producerFactory(){

         DefaultKafkaProducerFactory producerFactory=new DefaultKafkaProducerFactory(producerConfigs());
         return producerFactory;

     }

	@Bean
	public KafkaTemplate kafkaTemplate(ProducerFactory producerFactory) {
		return new KafkaTemplate(producerFactory);
	}

	private Map<String, Object> producerConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
		props.put(ProducerConfig.RETRIES_CONFIG, 0);
		props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
		props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
		props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return props;
	}

	/*
	 * @Bean public Map<String, Object> producerConfigs() { Map<String, Object>
	 * props = new HashMap<String,Object>();
	 * props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
	 * kafkaProperties.getBootstrapServers());
	 * props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
	 * StringSerializer.class);
	 * props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
	 * StringSerializer.class); return props; }
	 */

	/*
	 * @Bean public ProducerFactory producerFactory() { return new
	 * DefaultKafkaProducerFactory(producerConfigs()); }
	 * 
	 * @Bean public KafkaTemplate<String, String> kafkaTemplate() { return new
	 * KafkaTemplate(producerFactory()); }
	 */
}
