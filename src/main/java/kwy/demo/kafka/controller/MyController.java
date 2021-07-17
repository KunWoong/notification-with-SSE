package kwy.demo.kafka.controller;

import kwy.demo.kafka.subsciption.SubscriptionMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;


@RestController
public class MyController {

    @Autowired
    SubscriptionMap subscriptionMap;

    @GetMapping(path="/stream/notification/{userId}", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
    SseEmitter getStreamChannel(@PathVariable(name = "userId") String userId){
        SseEmitter sseEmitter = new SseEmitter(1000*60L);
        subscriptionMap.addSSE(userId, sseEmitter);
        return sseEmitter;
    }
    private SseEmitter emitter;
}
