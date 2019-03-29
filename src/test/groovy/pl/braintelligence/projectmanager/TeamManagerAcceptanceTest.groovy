package pl.braintelligence.projectmanager

import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpStatus
import pl.braintelligence.projectmanager.base.BaseIntegrationTest
import pl.braintelligence.projectmanager.core.team.domain.JobPosition
import pl.braintelligence.projectmanager.core.team.domain.Team

class TeamManagerAcceptanceTest extends BaseIntegrationTest {

    def "User flow while using project manager"() {
        given: "create a new team"
        prepareNewTeam("teamName")

        when: "get all created teams"
        def response = get('/teams', new ParameterizedTypeReference<List<Team>>() {})

        then: "team is created"
        response.statusCode == HttpStatus.OK
        response.body[0] != null

        when: "new member is added to a team"
        post('/teams/teamName/members', teamMemberDto).statusCode == HttpStatus.CREATED

        and: "retrieve new member"
        response = get('/teams', new ParameterizedTypeReference<List<Team>>() {})

        then: "verify new member"
        with(response.body[0].members[0]) {
            firstName == "first"
            lastName == "sec"
            jobPosition == JobPosition.DEVELOPER
        }
    }
}
