package pl.ejdev.publisher.services

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import pl.ejdev.publisher.config.KafkaConfigProps
import pl.ejdev.publisher.domain.Product

@Service
class KafkaProductService(
    private val objectMapper: ObjectMapper,
    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val props: KafkaConfigProps,
) : ProductService {
    override fun publish(product: Product) {
        objectMapper
            .runCatching { writeValueAsString(product) }
            .map { kafkaTemplate.send(props.topic, it) }
            .onFailure { throw IllegalStateException("Unable to publish: $product ", it) }
    }

}