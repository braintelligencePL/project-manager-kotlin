package pl.braintelligence.projectmanager.infrastructure.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.ClientHttpRequestFactory
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestTemplate

@Configuration
@EnableConfigurationProperties
class ClientConfiguration(
        @Value("\${client.connectTimeout}") private val connectTimeout: Int,
        @Value("\${client.readTimeout}") private val readTimeout: Int
) {

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate(clientHttpRequestFactory())
    }

    fun clientHttpRequestFactory(): ClientHttpRequestFactory {
        val factory = HttpComponentsClientHttpRequestFactory()
        factory.setReadTimeout(readTimeout)
        factory.setConnectTimeout(connectTimeout)
        return factory
    }
}
