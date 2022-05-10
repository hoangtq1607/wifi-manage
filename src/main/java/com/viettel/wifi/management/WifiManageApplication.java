package com.viettel.wifi.management;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.config.EnableWebFlux;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

@Log4j2
@SpringBootApplication
@EnableWebFlux
public class WifiManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(WifiManageApplication.class, args);
    }

    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageProducer inbound() {
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter("ws://broker.mqttdashboard.com:8000", "clientId-i77GAZqU6C",
                        "hoangtq111");
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return message -> {
            System.out.println(message.getPayload());
            sinkMany.emitNext(String.valueOf(message.getPayload()), (signalType, emitResult) -> {
                System.out.println(signalType + "--" + emitResult);
                return true;
            });
        };
    }

    Sinks.Many<String> sinkMany = Sinks.unsafe()
            .many().replay().latest();
}
