package br.com.regis.produtor.serializable;

import java.util.HashMap;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ProductorString {
	private final KafkaProperties properties;
	
	@Bean
	public ProducerFactory<String, String> producerFactory(){
		var configs=new HashMap<String, Object>();
		//busca localhost:29092
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
		//serializa a mensagem
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return new DefaultKafkaProducerFactory<String, String>(configs);
	}
	
	@Bean
	public KafkaTemplate<String, String> kafkaTemplate( ProducerFactory<String, String> producerFactory){
		return new KafkaTemplate<String, String>(producerFactory);
		
	}
}
