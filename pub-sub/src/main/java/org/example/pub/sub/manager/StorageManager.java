package org.example.pub.sub.manager;

import org.example.pub.sub.entity.Record;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StorageManager {
    private static StorageManager manager;
    public final HashMap<String, List<Record>> records;
    private final ConsumerManager consumerManager;

    private StorageManager() {
        records = new HashMap<>();
        consumerManager = ConsumerManager.getConsumerManager();
    }

    public static StorageManager getStorageManager() {
        if (manager == null) {
            manager = new StorageManager();
        }
        return manager;
    }

    public void addTopic(String topic) {
        if (records.containsKey(topic)) {
            System.out.println("Topic already exist..");
            return;
        }
        records.put(topic, new ArrayList<>());
        consumerManager.addTopic(topic);
    }

    public void addRecord(String topic, Record record) {
        records.get(topic).add(record);
        consumerManager.informConsumers(topic, records.get(topic));
    }
}
