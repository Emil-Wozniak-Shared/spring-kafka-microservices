package pl.ejdev.order.config

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories("pl.ejdev.order.repo")
@ConfigurationPropertiesScan(basePackages = ["pl.ejdev.order"])
class AppConfig