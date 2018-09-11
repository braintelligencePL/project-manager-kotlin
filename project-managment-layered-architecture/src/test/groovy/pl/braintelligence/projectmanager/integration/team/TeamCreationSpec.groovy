package pl.braintelligence.projectmanager.integration.team

import pl.braintelligence.projectmanager.integration.base.BaseIntegrationSpec
import pl.braintelligence.projectmanager.integration.team.base.OperatingOnTeamEndpoint
import spock.lang.Unroll

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import static pl.braintelligence.projectmanager.integration.team.base.SampleNewTeamDto.sampleNewTeamDto

class TeamCreationSpec extends BaseIntegrationSpec implements OperatingOnTeamEndpoint {

    def "Should not create a team that already exists"() {
        given: "create new team"
        createNewTeam(sampleNewTeamDto())

        when: "create team with already existing team-name"
        def response = createNewTeam(sampleNewTeamDto())

        then: "system throws that team already exist"
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.message == "TEAM_ALREADY_EXISTS"
    }

    @Unroll
    def "Should not create unnamed new-team"() {
        when: "post new team with empty-name"
        def response = createNewTeam(sampleNewTeamDto(name: name))

        then: "system cannot create a team with empty team-name"
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.message == "EMPTY_TEAM_NAME"

        where:
        name << ['', '  ']
    }
}
