package kwy.demo.kafka.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;
import java.util.Queue;

@Configuration
public class MessageQueue {
    Logger logger = LoggerFactory.getLogger(MessageQueue.class);
    @Bean("MessageQueue")
    public Queue<String> setting(){
        Queue<String> mq = new LinkedList<>();
        return mq;
    }

}
