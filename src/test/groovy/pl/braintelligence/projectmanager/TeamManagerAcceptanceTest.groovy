package pl.braintelligence.projectmanager

import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpStatus
import pl.braintelligence.projectmanager.base.BaseIntegrationTest
import pl.braintelligence.projectmanager.core.team.domain.JobPosition
import pl.braintelligence.projectmanager.core.team.domain.Team

class TeamManagerAcceptanceTest extends BaseIntegrationTest {

    def "User flow while using project manager"() {
        when: "new team is created"
        prepareNewTeam("teamName")

        then: "user gets all teams created"
        get('/teams', new ParameterizedTypeReference<List<Team>>() {}).statusCode == HttpStatus.OK

        when: "new member is added to a team"
        post('/teams/teamName/members', teamMemberDto).statusCode == HttpStatus.CREATED

        and: "browse for new member"
        def response = get('/teams', new ParameterizedTypeReference<List<Team>>() {})

        then: "verify new member is in a team"
        with(response.body[0].members[0]) {
            firstName == "first"
            lastName == "sec"
            jobPosition == JobPosition.DEVELOPER
        }
    }
}
