package pl.ejdev.order.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.text.SimpleDateFormat


@Configuration
class JsonConfig {
    @Bean
    fun objectMapper(): ObjectMapper = jacksonObjectMapper()
        .registerModule(JavaTimeModule())
        .setDateFormat(SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"))
}

