package kwy.demo.kafka.processor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;

@Component
public class MessageProducer extends Thread{
    Logger logger = LoggerFactory.getLogger(MessageProducer.class);

    @Autowired
    Queue<String> MessageQueue;

    @Override
    public void run() {
        int count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String inputData = "";
            try {
                Thread.sleep(1000);
                inputData = br.readLine();
                MessageQueue.add(inputData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
