package pl.braintelligence.projectmanager.team

import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpStatus
import pl.braintelligence.projectmanager.base.BaseIntegrationTest
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.ExistingTeam

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

    def "Should add member to a team"() {
        given:
        def teamName = "valid team name"
        prepareNewTeam(teamName)

        when: "team member is added"
        def response = post("/teams/$teamName/members", teamMemberDto)

        then:
        response.statusCode == HttpStatus.CREATED

        when: "teams are retrieved"
        response = get('/teams', new ParameterizedTypeReference<List<ExistingTeam>>() {})

        then: "new member is in a team"
        with(response.body[0].members[0]) {
            firstName == "first"
            lastName == "last"
            jobPosition == "DEVELOPER"
        }
    }
}
