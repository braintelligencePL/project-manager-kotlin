package pl.braintelligence.projectmanager.base

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity

import static org.springframework.http.HttpMethod.GET

trait BaseHttpMethodsTest {

    @Autowired
    TestRestTemplate restTemplate

    def <T> ResponseEntity<T> get(String uri, Class<T> responseBodyType) {
        return sendRequest(uri, GET, null, responseBodyType)
    }

    def <T> ResponseEntity<T> get(String uri, ParameterizedTypeReference<T> responseBodyType) {
        return sendRequest(uri, GET, null, responseBodyType)
    }

    ResponseEntity post(String uri, Object requestBody) {
        return sendRequest(uri, HttpMethod.POST, requestBody, Object)
    }

    def put(String uri, Object requestBody) {
        return sendRequest(uri, HttpMethod.PUT, requestBody, Object)
    }

    ResponseEntity patch(String uri) {
        return sendRequest(uri, HttpMethod.PATCH, null, Object)
    }

    ResponseEntity patch(String uri, Object requestBody) {
        return sendRequest(uri, HttpMethod.PATCH, requestBody, Object)
    }

    private <T> ResponseEntity<T> sendRequest(String uri, HttpMethod method, Object requestBody, Class<T> responseBodyType) {
        def entity = new HttpEntity<>(requestBody)
        return restTemplate.exchange(uri, method, entity, responseBodyType)
    }

    private <T> ResponseEntity<T> sendRequest(String uri, HttpMethod method, Object requestBody, ParameterizedTypeReference<T> responseBodyType) {
        def entity = new HttpEntity<>(requestBody)
        return restTemplate.exchange(uri, method, entity, responseBodyType)
    }

    def <T> HttpEntity<T> preparePayload(T data, Map<String, List<String>> additionalHeaders = [:]) {
        def headers = new HttpHeaders()

        headers.putAll(additionalHeaders)
        return new HttpEntity<T>(data, headers)
    }
}
