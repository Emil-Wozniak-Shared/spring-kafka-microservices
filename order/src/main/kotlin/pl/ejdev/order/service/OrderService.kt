package pl.ejdev.order.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import pl.ejdev.order.domain.Order
import java.util.*

interface OrderService {
    fun save(order: Order): Order
    fun getAll(pageable: Pageable): Page<Order>
    fun get(uuid: UUID): Order?
}
