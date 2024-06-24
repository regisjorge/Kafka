package br.com.regis.Consumer.deserializable;

import java.util.HashMap;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.RecordInterceptor;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Configuration
@Log4j2
public class ConsumerString {

	private final KafkaProperties propeties;
	
	@Bean
	public ConsumerFactory<String, String> consumerFactory(){
		var configs= new HashMap<String, Object>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, propeties.getBootstrapServers());
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<String, String>(configs);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> mContainerFactory(ConsumerFactory<String, String> consumerFactory){
		var factory= new ConcurrentKafkaListenerContainerFactory<String, String>();
		factory.setConsumerFactory(consumerFactory);
		factory.setRecordInterceptor(validMessage());
		return factory;
	}
	
	//interceptador
	private RecordInterceptor<String, String> validMessage(){
		return record ->{
			if(record.value().contains("Teste")) {
				log.info("Possui a palavra teste {}",record.value()) ;
				return record;
			}
			return record;
		};
	}
}
