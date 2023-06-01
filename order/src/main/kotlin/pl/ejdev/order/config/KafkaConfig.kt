package pl.ejdev.order.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.kafka.config.TopicBuilder

@Configuration
@Profile("production")
class KafkaConfig {
    @Bean
    fun booksPublishedTopic(props: KafkaConfigProps): NewTopic =
        TopicBuilder.name(props.topic)
            .partitions(10)
            .replicas(1)
            .build()
}
