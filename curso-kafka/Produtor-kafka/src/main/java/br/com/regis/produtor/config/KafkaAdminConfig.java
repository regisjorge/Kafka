package br.com.regis.produtor.config;

import java.util.HashMap;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class KafkaAdminConfig {

	public final KafkaProperties propeties;

	@Bean
	public KafkaAdmin kafkaAdmin() {
		var configs = new HashMap<String, Object>();
		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, propeties.getBootstrapServers());
		return new KafkaAdmin(configs);
	}

	@Bean
	public KafkaAdmin.NewTopics topics() {
		return new KafkaAdmin.NewTopics(
				TopicBuilder.name("strc-Topic").partitions(2).replicas(1).build()
				);
	}
}
