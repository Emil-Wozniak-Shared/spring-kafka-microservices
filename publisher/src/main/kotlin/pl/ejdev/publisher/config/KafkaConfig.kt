package pl.ejdev.publisher.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaConfig {
    @Bean
    fun booksPublishedTopic(props: KafkaConfigProps): NewTopic =
        props.run {
            TopicBuilder.name(topic)
                .partitions(partitions)
                .replicas(replicas)
                .build()
        }
}

