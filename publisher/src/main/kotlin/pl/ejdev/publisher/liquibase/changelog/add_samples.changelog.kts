package pl.ejdev.publisher.liquibase.changelog

import pl.ejdev.publisher.domain.Order
import pl.ejdev.publisher.domain.Product
import pl.ejdev.publisher.liquibase.fakeData.formatted
import pl.ejdev.publisher.liquibase.fakeData.orders
import pl.ejdev.publisher.liquibase.fakeData.products

private val separator = "\n"
fun createOrderRecord(order: Order) = """
    INSERT INTO public.orders (id, customer, created_at)
    VALUES ('${order.id}','${order.customer}', '${order.createdAt.formatted()}');
    """.trimIndent()

fun createProductRecord(product: Product) = """
    INSERT INTO public.products (id, code, order_id)
    VALUES ('${product.id}','${product.code}', (SELECT o.id FROM public.orders as o WHERE o.id = '${product.order.id}'));
    """.trimIndent()

databaseChangeLog {
    changeSet(id = "add-sample-orders-1", author = "emil.wozniak") {
        sql {
            comment("Add sample orders")
            -orders.joinToString(separator, transform = ::createOrderRecord)
        }
    }
    changeSet(id = "add-sample-products-1", author = "emil.wozniak") {
        sql {
            comment("Add sample products")
            -products.joinToString(separator, transform = ::createProductRecord)
        }
    }
}

