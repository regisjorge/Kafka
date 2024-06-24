package br.com.regis.Consumer.exceptions;

import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler{


	public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
		log.info("EXCEPTION_HANDLER ::: {}", message);
		log.info("PAYLOAD ::: {}", message.getPayload());
		log.info("HEADERS ::: {}", message.getHeaders());
		log.info("OFFSET ::: {}", message.getHeaders().get("kafka_offset"));
		log.info("MESSAGE_EXCEPTION ::: {}", exception.getMessage());
		return null;
	}

}
