package pl.ejdev.order.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import pl.ejdev.order.domain.Order
import pl.ejdev.order.repo.OrderRepo
import java.util.*
import kotlin.jvm.optionals.getOrNull

@Service
class OrderServiceImpl(
    private val repo: OrderRepo
) : OrderService {
    override fun save(order: Order): Order = repo.save(order)

    override fun getAll(pageable: Pageable): Page<Order> = repo.findAll(pageable)
    override fun get(uuid: UUID): Order? = repo.findById(uuid).getOrNull()
}