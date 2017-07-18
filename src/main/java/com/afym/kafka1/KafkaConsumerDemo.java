package com.afym.kafka1;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;

public class KafkaConsumerDemo {
    public static void main(String[] args) {
        // https://kafka.apache.org/documentation/#newconsumerconfigs
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
        properties.setProperty("key.deserializer", StringDeserializer.class.getName());
        properties.setProperty("value.deserializer", StringDeserializer.class.getName());

        properties.setProperty("group.id", "test");
        properties.setProperty("enable.auto.commit", "true");
        properties.setProperty("auto.commit.interval.ms", "1000");
        properties.setProperty("auto.offset.reset", "earliest");

        KafkaConsumer<String ,String> consumer = new KafkaConsumer<String, String>(properties);
        consumer.subscribe(Arrays.asList("second_topic"));

        while(true) {
            ConsumerRecords<String,String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(">>> Processing <<<");
                System.out.println("::: key " + record.key());
                System.out.println("::: topic " + record.topic());
                System.out.println(record.offset() + " " + record.value());
                System.out.println(">>> Ending <<<");
            }
        }
    }
}
