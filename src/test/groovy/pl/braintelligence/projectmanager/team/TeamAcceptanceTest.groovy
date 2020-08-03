package pl.braintelligence.projectmanager.team

import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpStatus
import pl.braintelligence.projectmanager.base.BaseIntegrationTest
import pl.braintelligence.projectmanager.core.team.domain.Team

class TeamAcceptanceTest extends BaseIntegrationTest {

    def "User flow while using project manager"() {
        when: "new teamName is created"
        prepareNewTeam(newTeamDto.name)

        then: "user gets all teams created"
        get('/teams', new ParameterizedTypeReference<List<Team>>() {})
                .statusCode == HttpStatus.OK

        when: "new member is added to a teamName"
        post('/teams/teamName/members', teamMemberDto)
                .statusCode == HttpStatus.CREATED

        then: "browse for new member"
        get('/teams', new ParameterizedTypeReference<List<Team>>() {})
                .statusCode == HttpStatus.OK
    }
}
