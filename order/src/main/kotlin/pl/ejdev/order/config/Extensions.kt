package pl.ejdev.order.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

inline fun <reified T> ObjectMapper.catchingReadValue(input: String): Result<T> =
    this.runCatching { readValue<T>(input) }