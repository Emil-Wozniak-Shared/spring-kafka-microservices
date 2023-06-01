package pl.ejdev.publisher.domain

import jakarta.persistence.*
import jakarta.persistence.CascadeType.ALL
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction.CASCADE
import java.util.*

@Entity
@Table(name = "products")
data class Product(
    @field:Id
    val id: UUID = UUID.randomUUID(),
    val code: String? = null,
    @field:ManyToOne(cascade = [ALL])
    @field:JoinColumn(name = "order_id", nullable = false)
    @field:OnDelete(action = CASCADE)
    val order: Order
)