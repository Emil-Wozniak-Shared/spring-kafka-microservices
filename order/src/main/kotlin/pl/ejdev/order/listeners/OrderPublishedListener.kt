package pl.ejdev.order.listeners

import com.fasterxml.jackson.databind.ObjectMapper
import mu.KotlinLogging
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import pl.ejdev.order.config.catchingReadValue
import pl.ejdev.order.domain.Notification
import pl.ejdev.order.domain.Order
import pl.ejdev.order.exception.InvalidMessageException
import pl.ejdev.order.service.NotificationService
import pl.ejdev.order.service.OrderService
import java.time.LocalDateTime
import java.util.*

private val logger = KotlinLogging.logger { }

private const val ORDER_SERVICE = "order-service"
private const val TOPICS = "order.publisher"
private const val GROUP_ID = "orders"

@Component
class OrderPublishedListener(
    private val objectMapper: ObjectMapper,
    private val orderService: OrderService,
    private val notificationService: NotificationService
) {

    @KafkaListener(topics = [TOPICS], groupId = GROUP_ID)
    fun listen(input: String): String = input.also {
        objectMapper
            .catchingReadValue<Map<String, Any>>(it)
            .map(::toOrder)
            .onFailure { throw InvalidMessageException }
            .map(orderService::save)
            .map(::toMessage)
            .map(::toNotification)
            .map(notificationService::publish)
            .onFailure { logger.error { "Invalid message received: $it" } }
    }

    private fun toMessage(order: Order): String =
        "Order ${order.id} for ${order.customer} persisted"

    private fun toNotification(message: String) =
        Notification(
            message = message,
            service = ORDER_SERVICE
        )

    private fun toOrder(json: Map<String, Any>) =
        Order(
            id = json["id"].toString().let(UUID::fromString),
            customer = json["customer"].toString(),
            createdAt = json["createdAt"].toString().let(LocalDateTime::parse)
        )
}