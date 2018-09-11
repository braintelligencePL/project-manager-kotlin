package pl.braintelligence.projectmanager.integration.team

import pl.braintelligence.projectmanager.integration.base.BaseIntegrationSpec
import pl.braintelligence.projectmanager.integration.team.base.OperatingOnTeamEndpoint
import spock.lang.Unroll

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import static pl.braintelligence.projectmanager.integration.team.base.SampleNewTeamDto.sampleNewTeamDto
import static pl.braintelligence.projectmanager.integration.team.base.SampleTeamMemberDto.sampleTeamMemberDto

class TeamMemberCreationSpec extends BaseIntegrationSpec implements OperatingOnTeamEndpoint {

    @Unroll
    def "Should not add new-member without first-name to a team"() {
        given: "new team is created"
        createNewTeam(sampleNewTeamDto())

        when: "adding member to a team without first-name"
        def response = addMemberToTeam(sampleTeamMemberDto(firstName: firstName), sampleNewTeamDto())

        then: "system response - invalid first-name"
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.message == 'EMPTY_MEMBER_FIRST_NAME'

        where:
        firstName << ['', '  ']
    }

    @Unroll
    def "Should not add new-member without last-name to a team"() {
        given: "new team is created"
        createNewTeam(sampleNewTeamDto())

        when: "adding member to a team without last-name"
        def response = addMemberToTeam(sampleTeamMemberDto(lastName: lastName), sampleNewTeamDto())

        then: "system response - invalid last-name"
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.message == 'EMPTY_MEMBER_LAST_NAME'

        where:
        lastName << ['', '  ']
    }

    def "Should not add new-member without valid job-description to a team"() {

    }

}
