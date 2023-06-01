package pl.ejdev.order.domain

import java.time.LocalDateTime

data class Notification(
    val message: String,
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val service: String,
)
