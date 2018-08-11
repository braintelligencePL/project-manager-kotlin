package pl.braintelligence.projectmanager.base

import org.junit.Rule
import com.github.tomakehurst.wiremock.junit.WireMockRule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.test.annotation.Rollback
import pl.braintelligence.projectmanager.Application
import spock.lang.Specification

@Rollback
@SpringBootTest(classes = [Application], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class BaseIntegrationTest extends Specification {

    @Autowired
    TestRestTemplate restTemplate

    @Autowired
    MongoTemplate mongo

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(12346)

    void setupSpec() { wiremockFix() }

    void setup() { clearMongoDb() }

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
