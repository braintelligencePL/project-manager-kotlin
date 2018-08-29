package pl.braintelligence.projectmanager.integration.team

import pl.braintelligence.projectmanager.integration.base.BaseIntegrationSpec
import pl.braintelligence.projectmanager.integration.team.base.OperatingOnTeamEndpoint

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import static pl.braintelligence.projectmanager.integration.team.base.SampleNewTeamDto.sampleNewTeamDto

class TeamFailureAcceptanceSpec extends BaseIntegrationSpec implements OperatingOnTeamEndpoint {

    def "Should not create an unnamed new team"() {
        when:
        def response = postNewTeam(sampleNewTeamDto())

        then:
        response.statusCode == UNPROCESSABLE_ENTITY

        where:
        name << [null, '', '  ']
    }

}
