# kafka-topics

### creating a topic
kafka-topics --zookeeper 127.0.0.1:2181 --create --topic my_topic --partitions 3 --replication-factor 1

### listing topics
kafka-topics --zookeeper 127.0.0.1:2181 --list

### getting the detail of topics
kafka-topics --zookeeper 127.0.0.1:2181 --describe --topic my_topic

### deleting a topic
kafka-topics --zookeeper 127.0.0.1:2181 --topic my_topic delete

### producing data
kafka-console-producer --broker-list 127.0.0.1:9092 --topic my_topic

### consume data
kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic my_topic
kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic my_topic --from-beginning
kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic my_topic --from-beginning --partition 0

### join inside the servers (docker)
docker-compose exec kafka-service bash
