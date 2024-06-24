package br.com.regis.Consumer.listeners.custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.kafka.annotation.KafkaListener;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@KafkaListener
public @interface CustomListener {

	@AliasFor(annotation = KafkaListener.class, attribute = "topics")
	String[] topics() default "strc-Topic";

	@AliasFor(annotation = KafkaListener.class, attribute = "containerFactory")
	String containerFactory() default "mContainerFactory";

	@AliasFor(annotation = KafkaListener.class, attribute = "groupId")
	String groupId() default "";
	
	@AliasFor(annotation = KafkaListener.class, attribute = "errorHandler")
	String errorHandler() default "errorCustomHandler";
}
