
--executar o conector mysql
C:\Users\regis\OneDrive\Documentos\Kafka\curso-kafka-connect\docs>
curl -X POST -H "Content-Type:application/json" http://localhost:8083/connectors -d @mysql.json

--executar o conector mysql
C:\Users\regis\OneDrive\Documentos\Kafka\curso-kafka-connect\docs>
curl -X POST -H "Content-Type:application/json" http://localhost:8083/connectors -d @postgres.json

--verificar se os conectors subiram
C:\Users\regis\OneDrive\Documentos\Kafka\curso-kafka-connect\docs>
curl -X GET http://localhost:8083/connectors



docker-compose restart kafka-connect
docker-compose logs kafka-connect

curl -X DELETE http://localhost:8083/connectors/mysql-connector-source

curl -X DELETE http://localhost:8083/connectors/postgres-connector-sink

["postgres-connector-sink","mysql-connector-source"]


http://localhost:8080/ adminer
localhost:5050 pgadmin

---------------------------------------------------------------------------------------------------------------------------------------------------------------------
docker run --name my-postgres -p 5432:5432 -e POSTGRES_PASSWORD=1234 -d postgres
docker ps
docker stop d1a

//apagar todos registros no docker
docker system prune -a
y

docker network create --driver bridge my-network
docker network ls
docker run --name my-postgres --network=my-network -p 5432:5432 -e POSTGRES_PASSWORD=1234 -d postgres
docker inspect my-network


docker run --name my-pgadmin --network=my-network -p 15432:80 -e PGADMIN_DEFAULT_EMAIL=regis.jorge@hotmail.com -e PGADMIN_DEFAULT_PASSWORD=1234 -d dpage/pgadmin4

http://localhost:15432/login?next=/
---------------------------------------------------------------------------------------------------------------------------------------------------------------------
docker run -p 3307:3306 --name my-mysql -e MYSQL_ROOT_PASSWORD=1234 -d mysql/mysql-server:5.7
docker ps -a

--acessar o mysql
docker exec -it my-mysql /bin/bash
mysql -uroot -p -A

select user,host from mysql.user;
update mysql.user set host='%' where user='root';
flush privileges;
exit

docker exec -it my-mysql /bin/bash
mysql -uroot -p -p1234 -h127.0.0.1
show databases;


mysql -uroot -p -p123456 -h127.0.0.1

docker exec -it docs-mysql-1 /bin/bash

mysql -uroot -p -p123456 -h127.0.0.1

mysql -uuser -p -p123456 -h127.0.0.1
show databases;


docker run --name some-mysql -v /my/custom:/etc/mysql/conf.d -e  MYSQL_ROOT_PASSWORD=123456 -d mysql:docs-mysql-1