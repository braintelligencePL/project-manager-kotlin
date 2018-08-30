package pl.braintelligence.projectmanager.integration.team

import pl.braintelligence.projectmanager.integration.base.BaseIntegrationSpec
import pl.braintelligence.projectmanager.integration.team.base.OperatingOnTeamEndpoint
import spock.lang.Unroll

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import static pl.braintelligence.projectmanager.integration.team.base.SampleNewTeamDto.sampleNewTeamDto

class TeamFailureAcceptanceSpec extends BaseIntegrationSpec implements OperatingOnTeamEndpoint {

    @Unroll
    def "Should not create an unnamed new team"() {
        when: "try to post new team with empty-name"
        def response = postNewTeam(sampleNewTeamDto(name: name))

        then: "system cannot create a team with empty team-name"
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.message == "EMPTY_TEAM_NAME"

        where:
        name << ['', '  ']
    }

    def "Should not create a team that already exists"() {
        given: "create new team"
        postNewTeam(sampleNewTeamDto())

        when: "create team with already existing team-name"
        def response = postNewTeam(sampleNewTeamDto())

        then: "throws exception "
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.message == "TEAM_ALREADY_EXISTS"
    }

}
