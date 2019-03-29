package pl.braintelligence.projectmanager.team

import org.springframework.core.ParameterizedTypeReference
import pl.braintelligence.projectmanager.base.BaseIntegrationTest
import pl.braintelligence.projectmanager.core.team.domain.Team

class TeamControllerTest extends BaseIntegrationTest {

    def "Should create a team and retrieve it"() {
        given:
        prepareNewTeam("teamName")

        when:
        def response = get('/teams', new ParameterizedTypeReference<List<Team>>() {})

        then:
        with(response.body[0]) {
            name == "teamName"
            currentlyImplementedProjects == 0
            members == []
        }
    }



}
