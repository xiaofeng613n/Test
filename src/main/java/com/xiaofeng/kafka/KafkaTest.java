package com.xiaofeng.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by xiaofeng on 2017/10/10
 * Description:
 */
public class KafkaTest
{
	public static void main(String[] args) throws ExecutionException, InterruptedException
	{
		testProducer();
		//testConsumer();
	}

	public static void testProducer() throws ExecutionException, InterruptedException
	{
		Properties props = new Properties();
		props.put("bootstrap.servers", "linux1:9093");//10.33.4.231:9092
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = new KafkaProducer<>(props);
		for(int i = 0; i < Integer.MAX_VALUE; i++)
		{
			String topic =  ( i % 2 ) == 0 ? "topic1" : "topic2";
			Future<RecordMetadata> send = producer.send(new ProducerRecord<String, String>(topic, Integer.toString(i), Integer.toString(i)));
			System.out.println("offset:" +send.get().offset());
			System.out.println("partition:" + send.get().partition());
			producer.flush();
			Thread.sleep(5000);
		}

		producer.close();
	}

	public static void testConsumer()
	{

		Properties props = new Properties();
		props.put("bootstrap.servers", "192.168.1.108:9093");//10.33.4.231:9092
		props.put("group.id", "groupC");
//		props.put("enable.auto.commit", "true");
//		props.put("auto.commit.interval.ms", "1000");
		props.put("auto.offset.reset", "earliest");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList("topicOfFlume")); //testFromFlume
		while (true)
		{
			ConsumerRecords<String, String> records = consumer.poll(100);
			for (ConsumerRecord<String, String> record : records)
			{
				System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
			}
		}
	}
}