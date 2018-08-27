package pl.braintelligence.projectmanager.integration.team

import pl.braintelligence.projectmanager.integration.base.BaseIntegrationSpec
import pl.braintelligence.projectmanager.integration.team.base.OperatingOnTeamEndpoint

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.OK
import static pl.braintelligence.projectmanager.integration.team.base.SampleNewTeamDto.sampleNewTeamDto

class TeamSuccessAcceptanceSpec extends BaseIntegrationSpec implements OperatingOnTeamEndpoint {

    def "Should create new team and browse it"() {
        when: "new team is created"
        def response = postNewTeam(sampleNewTeamDto())

        then: "system response that team is created"
        response.statusCode == CREATED

        when: "returns all created teams"
        response = getAllTeams()

        then: "checks that one team was created"
        response.statusCode == OK
        response.body.size() == 1

        and: "has default settings"
        with(response.body[0]) {
            name == sampleNewTeamDto().name
            currentlyImplementedProjects == 0
            true
            members == []
        }
    }
}