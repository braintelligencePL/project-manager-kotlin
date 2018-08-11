package pl.braintelligence.projectmanager.team

import groovy.json.JsonOutput
import pl.braintelligence.projectmanager.base.BaseIntegrationTest
import pl.braintelligence.projectmanager.team.base.OperatingOnTeamEndpoint

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.OK
import static pl.braintelligence.projectmanager.team.base.SampleNewTeamDto.NEW_TEAM_DTO
import static pl.braintelligence.projectmanager.team.base.SampleNewTeamDto.sampleNewTeamDto

class TeamEndpointAcceptanceTest extends BaseIntegrationTest implements OperatingOnTeamEndpoint {

    def "Should create new team and browse it"() {
        when: "new team is created"
        def response = postNewTeam(sampleNewTeamDto())

        then: "system creates new team"
        response.statusCode == CREATED

        when: "get created teams"
        response = getTeams()

        then: "verify that one team was created"
        response.statusCode == OK
        response.body.size() == 1

        and: "has default values"
        with(response.body[0]) {
            name == NEW_TEAM_DTO.name
            currentlyImplementedProjects == 0
            true
            members == []
        }
    }


}