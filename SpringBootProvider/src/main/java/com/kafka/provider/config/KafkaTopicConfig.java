package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {





    @Bean
    public NewTopic generateTopic(){



        Map<String,String> configurations = new HashMap<>();
        //(DELETE) borra el mensaje, (compact) contiene el mas actual!
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); //Tiempo de retencion de mensaje.Por defecto -1, No se borran nunca los mensajes
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824");//Tamanio maximo del segmento - 1gb
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "100000"); //Tamanio maximo de cada mensaje - defecto 1mb

        return TopicBuilder.name("JoaquinBrassinne-topic")
                .partitions(2)
                .replicas(2)
                .configs(configurations)
                .build();
    }
}
