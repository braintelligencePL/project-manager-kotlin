package pl.braintelligence.projectmanager.base

import com.github.tomakehurst.wiremock.junit.WireMockRule
import org.junit.Rule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.core.MongoTemplate
import pl.braintelligence.projectmanager.Application
import spock.lang.Specification

@SpringBootTest(classes = [Application], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class BaseIntegrationSpec extends Specification implements BaseHttpMethods{

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
