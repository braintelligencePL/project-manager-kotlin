package pl.braintelligence.projectmanager.integration.team

import org.springframework.http.ResponseEntity
import pl.braintelligence.projectmanager.integration.base.BaseIntegrationSpec
import pl.braintelligence.projectmanager.integration.team.base.OperatingOnTeamEndpoint

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.OK
import static pl.braintelligence.projectmanager.integration.team.base.SampleNewTeamDto.sampleNewTeamDto

class TeamSuccessAcceptanceSpec extends BaseIntegrationSpec implements OperatingOnTeamEndpoint {

    def "Should create new team and browse it"() {
        when: "new team is created"
        def response = postNewTeam(sampleNewTeamDto())
        response = postNewTeam(sampleNewTeamDto())

        then: "system response that team is created"
        response.body.message == "TEAM_ALREADY_EXISTS"
        response.statusCode == CREATED

//        when: "returns all created teams"
//        response = getAllTeams()
//
//        then: "checks that one team was created and has default settings"
//        response.statusCode == OK
//        response.body.size() == 1
//        hasDefaultSetting(response)

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
