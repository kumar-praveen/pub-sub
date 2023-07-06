package org.example.pub.sub.system;

import org.example.pub.sub.manager.ConsumerManager;
import org.example.pub.sub.manager.ProducerManager;

public class ProducerConsumerSystem {
    public static ProducerManager producerManager;
    public static ConsumerManager consumerManager;

    static {
        producerManager = ProducerManager.getProducerManager();
        consumerManager = ConsumerManager.getConsumerManager();
    }

    public String name;
    public String topic;

    public ProducerConsumerSystem(String name, String topic) {
        this.name = name;
        this.topic = topic;
    }
}
