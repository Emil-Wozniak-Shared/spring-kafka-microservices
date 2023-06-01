package pl.ejdev.order.repo

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import pl.ejdev.order.domain.Order
import java.util.UUID

interface OrderRepo: CrudRepository<Order, UUID>, PagingAndSortingRepository<Order, UUID>
