package pl.braintelligence.projectmanager.integration.team

import pl.braintelligence.projectmanager.integration.team.base.OperatingOnTeamEndpoint
import pl.braintelligence.projectmanager.integration.base.BaseIntegrationSpec
import org.springframework.http.ResponseEntity

import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.CREATED
import static pl.braintelligence.projectmanager.integration.team.base.SampleNewTeamDto.sampleNewTeamDto

class TeamAcceptanceSpec extends BaseIntegrationSpec implements OperatingOnTeamEndpoint {

    def "Should create new team and browse it"() {
        when: "new team is created"
        def response = postNewTeam(sampleNewTeamDto())

        then: "system response that team is created"
        response.statusCode == CREATED

        when: "user asks for all created teams"
        response = getAllTeams()

        then: "checks that one team was created and has default settings"
        response.statusCode == OK
        response.body.size() == 1
        hasDefaultSetting(response)
    }


    private boolean hasDefaultSetting(ResponseEntity response) {
        with(response.body[0]) {
            name == sampleNewTeamDto().name
            currentlyImplementedProjects == 0
            true
            members == []
        }
    }
}
