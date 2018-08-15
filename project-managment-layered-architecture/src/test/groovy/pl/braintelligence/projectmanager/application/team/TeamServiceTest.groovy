package pl.braintelligence.projectmanager.application.team

import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import pl.braintelligence.projectmanager.api.TeamEndpoint
import spock.lang.Specification

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TeamEndpoint.class)
class TeamServiceTest extends Specification {

    @Autowired
    private MockMvc mockMvc

    @MockBean
    private TeamService teamService

    def "test"() {

    }

}
