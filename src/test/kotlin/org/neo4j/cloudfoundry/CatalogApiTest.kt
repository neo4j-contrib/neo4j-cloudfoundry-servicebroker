package org.neo4j.cloudfoundry

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@RunWith(SpringRunner::class)
@WebMvcTest
class CatalogApiTest {

    @Autowired lateinit var mockMvc: MockMvc

    @Test
    fun `exposes a catalog endpoint`() {
        mockMvc.perform(get("/v2/catalog")).andExpect(status().isOk).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    }

    @Test
    fun `retrieves a catalog`() {
        mockMvc.perform(get("/v2/catalog")).andExpect(jsonPath("$.name", equalTo("neo4j-enterprise"))).andExpect(
                jsonPath("$.id", equalTo("fc42c8a4-25ca-49e5-9919-e7a03e18d814"))).andExpect(
                jsonPath("$.description", equalTo("the world's leading graph database"))).andExpect(jsonPath("$.bindable", equalTo(false))).andExpect(
                jsonPath("$.plans[0].id", equalTo("6973238a-b21a-4761-abaf-2eaadb4e3723"))).andExpect(
                jsonPath("$.plans[0].name", equalTo("enterprise edition"))).andExpect(
                jsonPath("$.plans[0].description", equalTo("enterprise-grade availability, management, and scale-up and scale-out capabilities"))).andExpect(
                jsonPath("$.plans[0].free", equalTo(false)))
    }
}
