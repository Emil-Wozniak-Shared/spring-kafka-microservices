package pl.ejdev.publisher

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class PublisherApplication

fun main(args: Array<String>) {
    runApplication<PublisherApplication>(*args)
}
