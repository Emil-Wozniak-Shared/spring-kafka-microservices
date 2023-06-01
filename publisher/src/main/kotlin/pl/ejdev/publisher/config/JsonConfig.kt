package pl.ejdev.publisher.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.text.SimpleDateFormat

const val DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

@Configuration
class JsonConfig {
    @Bean
    fun objectMapper(): ObjectMapper = jacksonObjectMapper()
//        .registerModule(JavaTimeModule())
        .setDateFormat(SimpleDateFormat(DATE_TIME_FORMAT))
}
