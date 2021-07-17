package kwy.demo.kafka.processor;

import kwy.demo.kafka.subsciption.SubscriptionMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Queue;

@Component
public class MessageListener extends Thread{

    @Autowired
    SubscriptionMap subscriptionMap;

    @Autowired
    Queue<String> MessageQueue;

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while(!MessageQueue.isEmpty()){
                subscriptionMap.sendMessage(MessageQueue.poll());
            }
        }
    }
}
