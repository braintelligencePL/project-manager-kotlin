package pl.braintelligence.projectmanager.team

import org.springframework.core.ParameterizedTypeReference
import pl.braintelligence.projectmanager.adapter.ExistingTeam
import pl.braintelligence.projectmanager.base.BaseIntegrationTest

class TeamControllerTest extends BaseIntegrationTest {

    def "Should create a team and retrieve it"() {
        given:
        prepareNewTeam("teamName")

        when:
        def response = get('/teams', new ParameterizedTypeReference<List<ExistingTeam>>() {})

        then:
        with(response.body[0]) {
            name == "teamName"
            currentlyImplementedProjects == 0
            members == []
        }
    }


}
