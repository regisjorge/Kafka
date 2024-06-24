package br.com.regis.produtor.services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProductorService {

	private final KafkaTemplate<String, String> kafkaTemplate;
	
	public void sedMessage(String message) {
		kafkaTemplate.send("strc-Topic",message).addCallback(
				success -> {
					if(success != null) {
						log.info("Send message with sucess {}",message);
						log.info("Partition {}, offset {}",success.getRecordMetadata().partition(),success.getRecordMetadata().offset());
					}
				},
				error -> log.error("Error send message {}", message)
				);
	}
}
