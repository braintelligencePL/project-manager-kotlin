package pl.braintelligence.projectmanager.team

import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpStatus
import pl.braintelligence.projectmanager.base.BaseIntegrationTest
import pl.braintelligence.projectmanager.core.team.Team

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

    def "Should not create team that already exist"() {
        given:
        def teamName = "teamName"
        prepareNewTeam(teamName)

        when:
        def response = prepareNewTeam(teamName)

        then:
        with(response) {
            body.status == HttpStatus.UNPROCESSABLE_ENTITY
            body.message == "Team already exist"
        }
    }
}
