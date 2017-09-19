package org.neo4j.cloudfoundry

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class ServiceBroker

fun main(args: Array<String>) {
    SpringApplication.run(ServiceBroker::class.java, *args)
}
