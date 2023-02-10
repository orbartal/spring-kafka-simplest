# spring-kafka-simplest

The simplest example of Spring Boot and Apache Kafka.
Please note that you must run kafka separately.

## Install and run kafka
See how to run Apache Kafka in Windows and Linux
- https://dzone.com/articles/running-apache-kafka-on-windows-os
  - https://stackoverflow.com/questions/53428903/zookeeper-is-not-a-recognized-option-when-executing-kafka-console-consumer-sh
- https://tecadmin.net/install-apache-kafka-ubuntu/

## Build and test
- mvn clean install -DskipTests
- mvn -Dtest=MainKafkaSpringSimplestTests test
