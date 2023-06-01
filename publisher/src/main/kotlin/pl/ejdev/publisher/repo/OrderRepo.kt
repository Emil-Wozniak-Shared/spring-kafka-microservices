package pl.ejdev.publisher.repo

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import pl.ejdev.publisher.domain.Product
import java.util.*

interface OrderRepo : CrudRepository<Product, UUID>, PagingAndSortingRepository<Product, UUID>