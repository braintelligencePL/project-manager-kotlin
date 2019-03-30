package pl.braintelligence.projectmanager.base

import com.github.tomakehurst.wiremock.junit.WireMockRule
import org.junit.Rule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.http.ResponseEntity
import pl.braintelligence.projectmanager.adapter.NewTeam
import pl.braintelligence.projectmanager.adapter.TeamMember
import pl.braintelligence.projectmanager.base.http.BaseHttpEndpoints
import pl.braintelligence.projectmanager.base.http.BaseHttpMethods
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@SpringBootTest(webEnvironment = RANDOM_PORT)
class BaseIntegrationTest extends Specification implements BaseHttpMethods, BaseHttpEndpoints {

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

    protected TeamMember teamMemberDto = new TeamMember("first", "sec", "DEVELOPER")

    protected ResponseEntity prepareNewTeam(String teamName) {
        def newTeam = new NewTeam(teamName)
        post(TEAMS_ENDPOINT, newTeam)
    }
}
