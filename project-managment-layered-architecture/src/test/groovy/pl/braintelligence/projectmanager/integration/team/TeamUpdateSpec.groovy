package pl.braintelligence.projectmanager.integration.team

import pl.braintelligence.projectmanager.integration.base.BaseIntegrationSpec
import pl.braintelligence.projectmanager.integration.team.base.OperatingOnTeamEndpoint
import spock.lang.Unroll

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import static pl.braintelligence.projectmanager.integration.team.base.SampleNewTeamDto.sampleNewTeamDto

class TeamUpdateSpec extends BaseIntegrationSpec implements OperatingOnTeamEndpoint {

    @Unroll
    def "Should not create an unnamed new team"() {
        when: "new team is created with empty-name"
        def response = createNewTeam(sampleNewTeamDto(name: name))

        then: "system cannot create a team with empty team-name"
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.message == "EMPTY_TEAM_NAME"

        where:
        name << ['', '  ']
    }

    def "Should not create a team that already exists"() {
        given: "create new team"
        createNewTeam(sampleNewTeamDto())

        when: "create team with already existing team-name"
        def response = createNewTeam(sampleNewTeamDto())

        then: "throws exception that team already exist"
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.message == "TEAM_ALREADY_EXISTS"
    }
}
