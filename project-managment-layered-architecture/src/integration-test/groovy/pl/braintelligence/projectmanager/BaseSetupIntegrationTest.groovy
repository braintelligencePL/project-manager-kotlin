package pl.braintelligence.projectmanager

import com.github.tomakehurst.wiremock.junit.WireMockRule
import org.junit.Rule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.core.ParameterizedTypeReference
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import spock.lang.Specification

@SpringBootTest(
        classes = [Application],
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BaseSetupIntegrationTest extends Specification {

    @Autowired
    TestRestTemplate restTemplate
    @Autowired
    MongoTemplate mongo

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(12346)

    void setupSpec() {
        wiremockFix()
    }

    void setup() {
        clearMongoDb()
    }

    protected static <T> HttpEntity<T> preparePayload(T data, Map<String, List<String>> additionalHeaders = [:]) {
        def headers = new HttpHeaders()

        headers.putAll(additionalHeaders)
        return new HttpEntity<T>(data, headers)
    }

    protected <T> ResponseEntity<T> get(String uri, Class<T> responseBodyType) {
        return sendRequest(uri, HttpMethod.GET, null, responseBodyType)
    }

    protected <T> ResponseEntity<T> get(String uri, ParameterizedTypeReference<T> responseBodyType) {
        return sendRequest(uri, HttpMethod.GET, null, responseBodyType)
    }

    protected ResponseEntity post(String uri, Object requestBody) {
         return sendRequest(uri, HttpMethod.POST, requestBody, Object)
    }

    protected ResponseEntity put(String uri, Object requestBody) {
        return sendRequest(uri, HttpMethod.PUT, requestBody, Object)
    }

    protected ResponseEntity patch(String uri) {
        return sendRequest(uri, HttpMethod.PATCH, null, Object)
    }

    protected ResponseEntity patch(String uri, Object requestBody) {
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

    private static void wiremockFix() {
        System.setProperty('http.keepAlive', 'false')
        System.setProperty('http.maxConnections', '1')
    }

    private void clearMongoDb() {
        for (def collection : mongo.collectionNames) {
            mongo.dropCollection(collection)
        }
    }
}
