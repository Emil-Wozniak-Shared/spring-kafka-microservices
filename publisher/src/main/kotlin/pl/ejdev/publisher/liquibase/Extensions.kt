package pl.ejdev.publisher.liquibase

import liquibase.change.ColumnConfig
import org.liquibase.kotlin.KotlinColumn
import org.liquibase.kotlin.KotlinColumnConstraint

internal fun KotlinColumn<ColumnConfig>.uuid(
    name: String,
    constraint: ((KotlinColumnConstraint).() -> Unit)? = null) {
    column(name = name, type = "uuid", constraint = constraint)
}

internal fun varchar(length: Int = 255): String = "varchar($length)"