package org.example.pub.sub.system;

import org.example.pub.sub.entity.Record;

import java.util.List;

public class Consumer extends ProducerConsumerSystem {
    private int idx;

    public Consumer(String name, String topic) {
        super(name, topic);
        idx = 0;
    }

    synchronized public void consumeRecord(List<Record> records) {
        while (idx < records.size()) {
            System.out.println("Consumer: " + name + " Record: " + records.get(idx));
            idx++;
        }
    }
}