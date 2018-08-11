package pl.braintelligence.projectmanager.team

import org.springframework.core.ParameterizedTypeReference
import pl.braintelligence.projectmanager.BaseSetupIntegrationTest
import pl.braintelligence.projectmanager.application.team.dto.ExistingTeam
import pl.braintelligence.projectmanager.application.team.dto.NewTeamDto

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.OK

class TeamEndpointTest extends BaseSetupIntegrationTest {

    def "Should create new team"() {
        given:
        def teamName = "Team1"

        when:
        def response = post('/teams', new NewTeamDto(teamName))

        then:
        response.statusCode == CREATED

        when:
        response = get('/teams', new ParameterizedTypeReference<List<ExistingTeam>>() {})

        then:
        response.statusCode == OK
        response.body == ([name: teamName])
        response.body.size() == 1
        with(response.body[0]) {
            name == 'Team 1'
            currentlyImplementedProjects == 0
            !busy
            members == []
        }
    }
}
