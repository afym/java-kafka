package com.afym.kafka1;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaProducerDemo {
    public static void main(String[] args) {
        // https://kafka.apache.org/documentation/#producerconfigs
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());
        properties.setProperty("acks", "1");
        properties.setProperty("retries", "3");

        Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(properties);
        ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("second_topic", "3", "holasss");
        producer.send(producerRecord);
        producer.close();
    }
}
