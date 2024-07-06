package xom.regis.Json_sr_producer.config;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xom.regis.Json_sr_producer.dto.*;

import java.math.BigDecimal;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Configuration
public class ProducerClientWithSR {

    private final static String BOOTSTRAP_SERVER = "broker:9092";  // Nome do serviço do Kafka Broker
    private final static String TOPIC = "employee";

    @Bean
    public String createTopico() throws ExecutionException, InterruptedException {
        Properties conf = new Properties();
        conf.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        conf.put(ProducerConfig.ACKS_CONFIG, "all");
        conf.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        conf.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "io.confluent.kafka.serializers.json.KafkaJsonSchemaSerializer");
        conf.put("schema.registry.url", "http://127.0.0.1:8081");

        KafkaProducer<String, Employee> producer = new KafkaProducer<>(conf);

        long currentTime = System.currentTimeMillis();
        Employee employee = new Employee("E002", "Regis", 30, "VP", new BigDecimal(189.5),
                ImmutableMap.of("X", 4, "Y", 8), ImmutableList.of("Eli", "Ed"), new Address("China", "GD", "GZ"));
        ProducerRecord<String, Employee> producerRecord = new ProducerRecord<>(TOPIC, null, currentTime, null, employee);

        Future<RecordMetadata> future = producer.send(producerRecord, (metadata, exception) -> {
            if (exception != null) {
                System.err.println("Erro ao enviar o registro para o Kafka: " + exception.getMessage());
            } else {
                System.out.println("Registro enviado com sucesso para o tópico: " + metadata.topic());
            }
        });

        producer.flush();
        future.get();  // Aguarda a confirmação do envio
        producer.close();

        return "success";
    }

}