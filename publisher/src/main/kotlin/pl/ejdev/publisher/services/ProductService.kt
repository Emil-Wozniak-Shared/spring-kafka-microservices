package pl.ejdev.publisher.services

import pl.ejdev.publisher.domain.Product

interface ProductService {
    fun publish(product: Product)
}