package org.neo4j.cloudfoundry.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class CatalogController {

    @GetMapping("/v2/catalog")
    fun getCatalogInfo(): CatalogInfo {
        val enterprisePlan = Plan(UUID.fromString("6973238a-b21a-4761-abaf-2eaadb4e3723"), "neo4j-enterprise-edition",
                "enterprise-grade availability, management, and scale-up and scale-out capabilities", false)
        val service = Service("neo4j", UUID.fromString("fc42c8a4-25ca-49e5-9919-e7a03e18d814"), "the world's leading graph database", false,
                listOf(enterprisePlan))

        return CatalogInfo(listOf(service))
    }
}

data class CatalogInfo(val services: List<Service>)

data class Service(val name: String, val id: UUID, val description: String, val bindable: Boolean, val plans: List<Plan>)

data class Plan(val id: UUID, val name: String, val description: String, val free: Boolean)
