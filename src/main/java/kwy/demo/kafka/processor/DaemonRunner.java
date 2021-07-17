package kwy.demo.kafka.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DaemonRunner implements ApplicationRunner {
    @Autowired
    MessageListener listener;

    @Autowired
    MessageProducer producer;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        producer.start();
        listener.start();
    }
}
