O Docker desktop deve estar rodando na maquina
Vá ate o endereço do arquivo docker-compose.yml no cmd
execute o comando
docker-compose up -d

retorno
 ✔ Container arquivo-zookkeper-docker-zookeeper-3-1  Runnin...                                                    0.0s
 ✔ Container arquivo-zookkeper-docker-zookeeper-1-1  Runnin...                                                    0.0s
 ✔ Container arquivo-zookkeper-docker-zookeeper-2-1  Runnin...                                                    0.0s
 ✔ Container arquivo-zookkeper-docker-kafka-3-1      Running                                                      0.0s
 ✔ Container arquivo-zookkeper-docker-kafka-1-1      Running                                                      0.0s
 ✔ Container arquivo-zookkeper-docker-kafka-2-1      Running                                                      0.0s

entrar na (maquina)
docker exec -it arquivo-zookkeper-docker-kafka-1-1 bash

-- criar o topico
kafka-topics --create --bootstrap-server localhost:29092 --replication-factor 3 --partitions 3 --topic meutopico

-- ver os topicos
kafka-topics --list --bootstrap-server localhost:29092

--envia para o topico
kafka-console-producer --broker-list localhost:29092 --topic meutopico


--para o consumer
entrar na (maquina)
docker exec -it arquivo-zookkeper-docker-kafka-1-1 bash
kafka-console-consumer --bootstrap-server localhost:29092 --topic meutopico
-- traz todas as mensagem desde o inicio
kafka-console-consumer --bootstrap-server localhost:29092 --topic meutopico --from-beginning
-- traz todas as mensagem desde o inicio grupo a
kafka-console-consumer --bootstrap-server localhost:29092 --topic meutopico --from-beginning --group a
--ver as particoes
kafka-topics --describe --bootstrap-server localhost:29092 --topic meutopico
--ver os consumos (offset)
 kafka-consumer-groups --group a --bootstrap-server localhost:29092 --describe