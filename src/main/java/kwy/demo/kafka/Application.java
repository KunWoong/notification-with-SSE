package kwy.demo.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//        MessageProducerConfiguration producer = new MessageProducerConfiguration();
//        producer.start();
//        MessageListenerConfiguration listener = new MessageListenerConfiguration();
//        listener.start();
    }

//    @Bean
//    public ApplicationRunner daemon(){
//        return new ApplicationRunner() {
//            @Override
//            public void run(ApplicationArguments args) throws Exception {
//
//            }
//        };
//    }
}
