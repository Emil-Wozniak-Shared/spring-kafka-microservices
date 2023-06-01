package pl.ejdev.publisher.liquibase

databaseChangeLog {
    changeSet(id = "init-1", author = "emil.wozniak") {
        include(file = "changelog/init.changelog.kts", relativeToChangelogFile = true)
        include(file = "changelog/add_samples.changelog.kts", relativeToChangelogFile = true)
    }
}