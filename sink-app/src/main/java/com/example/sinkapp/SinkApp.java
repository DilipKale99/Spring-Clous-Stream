package com.example.sinkapp;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;



@EnableBinding(GreetingsStreams.class)
@SpringBootApplication
@Component
public class SinkApp {

    public static void main(String[] args) {
        SpringApplication.run(SinkApp.class, args);
    }

    @StreamListener(GreetingsStreams.INPUT)
    public void handleGreetings(@Payload Greetings greetings) {
       System.out.println("Received greetings:" +greetings.getMessage());
    }
}
