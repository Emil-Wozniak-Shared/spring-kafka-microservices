package pl.ejdev.publisher.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "ejdev.kafka")
class KafkaConfigProps(
    var topic: String,
    var partitions: Int =  10,
    var replicas: Int = 1

)
