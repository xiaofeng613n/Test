package com.xiaofeng.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Arrays;
import java.util.Properties;

/**
 * Created by xiaofeng on 2017/10/10
 * Description:
 */
public class KafkaTest
{
	public static void main(String[] args)
	{
		testConsumer();
		//testProducer();
	}

	public static void testProducer()
	{
		Properties props = new Properties();
		props.put("bootstrap.servers", "10.33.4.238:9092");
		props.put("acks", "1");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		KafkaProducer kp = new KafkaProducer<String, String>(props);
		for(int i = 0; i < 100; i++)
		{
			kp.send(new ProducerRecord<>("kafkatopic", Integer.toString(i), Integer.toString(i)));
		}
	}

	public static void testConsumer()
	{
		Properties props = new Properties();
		props.put("bootstrap.servers", "10.33.4.238:9092");
		props.put("group.id", "test");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList("kafkatopic"));
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(100);
			for (ConsumerRecord<String, String> record : records)
				System.out.printf("offset = %d, key = %s, value = %s\n", record.offset(), record.key(), record.value());
		}
	}
}