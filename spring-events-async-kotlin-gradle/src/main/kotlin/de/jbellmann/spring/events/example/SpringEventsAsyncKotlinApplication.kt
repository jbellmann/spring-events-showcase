package de.jbellmann.spring.events.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling

@EnableAsync
@EnableScheduling
@SpringBootApplication
class SpringEventsAsyncKotlinApplication

fun main(args: Array<String>) {
    runApplication<SpringEventsAsyncKotlinApplication>(*args)
}
