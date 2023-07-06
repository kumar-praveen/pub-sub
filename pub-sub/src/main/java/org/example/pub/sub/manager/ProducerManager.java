package org.example.pub.sub.manager;

import org.example.pub.sub.entity.Record;
import org.example.pub.sub.system.Producer;

public class ProducerManager {
    private static ProducerManager manager;
    private final StorageManager storageManager;

    private ProducerManager() {
        storageManager = StorageManager.getStorageManager();
    }

    public static ProducerManager getProducerManager() {
        if (manager == null) {
            manager = new ProducerManager();
        }
        return manager;
    }

    public void producerRecord(Producer producer, Record record) {
        storageManager.addRecord(producer.topic, record);
    }

    public void addTopic(String topic) {
        storageManager.addTopic(topic);
    }
}
