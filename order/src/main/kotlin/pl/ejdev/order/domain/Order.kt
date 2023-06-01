package pl.ejdev.order.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "orders")
data class Order(
    @Id
    val id: UUID = UUID.randomUUID(),
    val customer: String? = null,
    val createdAt: LocalDateTime = LocalDateTime.now(),
)
