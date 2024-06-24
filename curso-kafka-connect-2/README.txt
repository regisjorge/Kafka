docker-compose up -d
docker-compose ps

docker exec -it curso-kafka-connect-2-mysql-1 bash
mysql -uroot -p
use products

create table products(id int, name varchar(255));

ver==> confluent (monitora o kafka)
http://localhost:9021/
connect
upload connector config file =>mysql.propeties

insert into products values(1, 'carrinho');

connect
clicar connect-default
add connector
upload connector config file =>es-skink.propeties

kibana ==> tela do elasticksource
http://localhost:5601/
3 tracinhos
Stack Management =>Index Management

criar padrao index no kibana
Index Patterns

Index pattern name
mysql-server*
NEXT STEP =>Create index pattern

==>ver
3 tracinhos
Discover
--------------------------------------------------------------------------------------------------------------

https://www.youtube.com/watch?v=qO4JL38_F1s&list=PL5aY_NrL1rjt_AZxj11kQjiTNLGg4ZaZA&index=6