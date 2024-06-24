package br.com.regis.Consumer.listeners;

import org.springframework.stereotype.Component;

import br.com.regis.Consumer.listeners.custom.CustomListener;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ConsumerListener {

	@SneakyThrows
	@CustomListener(groupId = "grupo-1")
	public void listener(String message) {
		log.info("Receiver message {}",message);
		throw new IllegalArgumentException("Error...");
	}
	
	@CustomListener(groupId = "grupo-1")
	public void listener2(String message) {
		log.info("Receiver-2 message {}",message);
	}
	
	@CustomListener(groupId = "grupo-2")
	public void history(String message) {
		log.info("History-2 message {}",message);
	}
}
