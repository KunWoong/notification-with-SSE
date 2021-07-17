package kwy.demo.kafka.subsciption;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class SubscriptionMap {
    private Map<String, Set<SseEmitter>> subscriptionSetMap;

    @PostConstruct
    public void init() {
        this.subscriptionSetMap = new HashMap<>();
    }

    public void addSSE(String userId, SseEmitter subscriberChannel){
        if(!subscriptionSetMap.containsKey(userId)){
            subscriptionSetMap.put(userId, new HashSet<>());
        }
        subscriptionSetMap.get(userId).add(subscriberChannel);
    }
    public void removeSSE(String userId){
        subscriptionSetMap.remove(userId);
    }

    public void sendMessage(String message){
        subscriptionSetMap.forEach((s, sseEmitters) -> {
            sseEmitters.forEach(sseEmitter -> {
                try {
                    sseEmitter.send("you are '" + s + "'  and received message : " + message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        });
    }
    public Set<SseEmitter> getSetByUserId(String userId){
        return subscriptionSetMap.get(userId);
    }
}
