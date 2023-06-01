package pl.ejdev.publisher.liquibase.fakeData

import pl.ejdev.publisher.config.DATE_TIME_FORMAT
import pl.ejdev.publisher.domain.Order
import pl.ejdev.publisher.domain.Product
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

private object ProductsResource {
    val names = this::class.java.getResourceAsStream("/samples/product_names.txt")
        .let(::requireNotNull)
        .bufferedReader()
        .readLines()
}

private val random = Random()
fun LocalDateTime.formatted(): String = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT, Locale.ENGLISH).format(this)

private val names =
    listOf("Emil", "Ola", "Michał", "Bartosz", "Sylwia", "Aga", "Ewa", "Marek", "Gosia", "Goha", "Patrycja")

val orders = names.map { Order(UUID.randomUUID(), it, LocalDateTime.now()) }

val products = orders.flatMap { order ->
    (0..10).map {
        Product(
            id = UUID.randomUUID(),
            code = random.nextInt(0, ProductsResource.names.size - 1)
                .let(ProductsResource.names::get)
                .replace("'", "`"),
            order = order
        )
    }
}