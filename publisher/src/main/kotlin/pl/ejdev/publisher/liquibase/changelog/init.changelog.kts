package pl.ejdev.publisher.liquibase.changelog

import pl.ejdev.publisher.liquibase.DATETIME
import pl.ejdev.publisher.liquibase.uuid
import pl.ejdev.publisher.liquibase.varchar

databaseChangeLog {
    changeSet(id = "init-tables-1", author = "emil.wozniak") {
        createTable(tableName = "orders") {
            uuid(name = "id") {
                constraints(
                    nullable = false,
                    primaryKey = true,
                )
            }
            column(name = "customer", type = varchar()) {
                constraints(nullable = false)
            }
            column(name = "created_at", type = DATETIME)
        }
        createTable(tableName = "products") {
            uuid(name = "id") {
                constraints(
                    nullable = false,
                    primaryKey = true,
                )
            }
            column(name = "code", type = varchar()) {
                constraints(nullable = false)
            }
            uuid(name = "order_id") {
                constraints(nullable = false)
            }
        }
        addForeignKeyConstraint(
            baseColumnNames = "order_id",
            baseTableName = "products",
            constraintName = "fk_order_id_product_id",
            referencedColumnNames = "id",
            referencedTableName = "orders",
        )
    }
}