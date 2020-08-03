package pl.braintelligence.projectmanager.base

import com.github.tomakehurst.wiremock.junit.WireMockRule
import org.junit.Rule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.http.ResponseEntity
import pl.braintelligence.projectmanager.base.http.BaseHttpMethods
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.team.NewTeam
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@SpringBootTest(webEnvironment = RANDOM_PORT)
class BaseIntegrationTest extends Specification implements BaseHttpMethods, BaseDtoObjects {

    @Rule
    public WireMockRule reportingService = new WireMockRule(8081)

    @Autowired
    private TestRestTemplate restTemplate

    @Autowired
    private MongoTemplate mongoTemplate

    void setup() {
        clearMongoDB()
    }

    private void clearMongoDB() {
        for (def collection : mongoTemplate.collectionNames) {
            mongoTemplate.dropCollection(collection)
        }
    }

    protected ResponseEntity prepareNewTeam(String teamName) {
        def newTeam = new NewTeam(teamName)
        post("/teams", newTeam)
    }

    protected ResponseEntity prepareNewProject() {
        post("/projects", newProjectWithFeaturesDto)
    }
}
