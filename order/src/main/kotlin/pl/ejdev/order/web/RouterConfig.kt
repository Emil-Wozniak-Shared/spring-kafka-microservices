package pl.ejdev.order.web

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.function.router

@Configuration
class RouterConfig(
    private val handler: OrderHandler
) {

    @Bean
    fun routes() = router {
        "api".nest {
            "order".nest {
                GET("", handler::getAll)
                GET("/", handler::getAll)
                GET("{id}", handler::get)
            }
        }
    }
}
