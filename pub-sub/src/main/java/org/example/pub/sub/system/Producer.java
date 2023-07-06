package org.example.pub.sub.system;

import org.example.pub.sub.entity.Record;

public class Producer extends ProducerConsumerSystem {
    public Producer(String name, String topic) {
        super(name, topic);
    }

    public void produceRecord(Record record) {
        producerManager.producerRecord(this, record);
    }
}
