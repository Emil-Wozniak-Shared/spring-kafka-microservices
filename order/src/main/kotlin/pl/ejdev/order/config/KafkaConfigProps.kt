package pl.ejdev.order.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "ejdev.kafka.notification")
open class KafkaConfigProps(
    var topic: String
)
