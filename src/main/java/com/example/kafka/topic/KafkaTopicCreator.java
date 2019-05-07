package com.example.kafka.topic;

import org.apache.kafka.clients.admin.NewTopic;

public class KafkaTopicCreator {
    public NewTopic newTopic(String name, int numPartitions, short replicationFactor) {
        return new NewTopic(name, numPartitions, replicationFactor);
    }

}
