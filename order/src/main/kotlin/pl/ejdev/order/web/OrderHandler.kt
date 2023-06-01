package pl.ejdev.order.web

import mu.KotlinLogging
import org.springframework.stereotype.Component
import org.springframework.web.servlet.function.ServerRequest
import org.springframework.web.servlet.function.ServerResponse
import org.springframework.web.servlet.function.ServerResponse.notFound
import org.springframework.web.servlet.function.ServerResponse.ok
import pl.ejdev.order.config.pageable
import pl.ejdev.order.service.OrderService
import java.util.*


private val logger = KotlinLogging.logger { }

@Component
class OrderHandler(
    private val service: OrderService
) {
    fun get(request: ServerRequest): ServerResponse =
        request.pathVariable("id")
            .let(UUID::fromString)
            .also { logger.info { "request order by id: $it" } }
            .let(service::get)
            ?.let { ok().body(it) }
            ?: notFound().build()

    fun getAll(request: ServerRequest): ServerResponse =
        logger.info { "request all orders" }
            .run {service.getAll(pageable).let { ok().body(it) } }
}