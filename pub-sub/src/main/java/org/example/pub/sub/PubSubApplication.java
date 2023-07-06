package org.example.pub.sub;

import org.example.pub.sub.entity.Record;
import org.example.pub.sub.manager.ConsumerManager;
import org.example.pub.sub.manager.ProducerManager;
import org.example.pub.sub.system.Consumer;
import org.example.pub.sub.system.Producer;

import java.util.Scanner;

public class PubSubApplication {
    public static void main(String[] args) {
        System.out.println("Starting Application!");

        String topic = "test-topic";
        ProducerManager producerManager = ProducerManager.getProducerManager();
        producerManager.addTopic(topic);
        Producer producer = new Producer("test-producer", topic);

        ConsumerManager consumerManager = ConsumerManager.getConsumerManager();
        Consumer c1 = new Consumer("test-consumer-1", topic);
        Consumer c2 = new Consumer("test-consumer-2", topic);
        Consumer c3 = new Consumer("test-consumer-3", topic);
        consumerManager.addConsumer(c1);
        consumerManager.addConsumer(c2);
        consumerManager.addConsumer(c3);


        Scanner scn = new Scanner(System.in);
        int recordsCountLimit = 0;
        while (recordsCountLimit < 100) {
            String data = scn.next();
            Record record = new Record(data);
            producer.produceRecord(record);
            recordsCountLimit++;
        }
        scn.close();
    }
}