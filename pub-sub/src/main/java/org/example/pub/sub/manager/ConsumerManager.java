package org.example.pub.sub.manager;

import org.example.pub.sub.entity.Record;
import org.example.pub.sub.system.Consumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConsumerManager {
    private static ConsumerManager manager;
    public final HashMap<String, List<Consumer>> consumers;

    private ConsumerManager() {
        consumers = new HashMap<>();
    }

    public static ConsumerManager getConsumerManager() {
        if (manager == null) {
            manager = new ConsumerManager();
        }
        return manager;
    }

    public void informConsumers(String topic, List<Record> records) {
        ConsumerManager consumerManager = ConsumerManager.getConsumerManager();
        for (Consumer consumer : manager.consumers.get(topic)) {
            new Thread(() -> {
                consumer.consumeRecord(records);
            }).start();
        }
    }

    public void addTopic(String topic) {
        consumers.put(topic, new ArrayList<>());
    }

    public void addConsumer(Consumer consumer) {
        consumers.get(consumer.topic).add(consumer);
    }
}
