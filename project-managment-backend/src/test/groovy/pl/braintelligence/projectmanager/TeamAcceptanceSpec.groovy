package pl.braintelligence.projectmanager

import pl.braintelligence.projectmanager.base.BaseIntegrationSpec
import pl.braintelligence.projectmanager.team.base.OperatingOnTeamEndpoint
import pl.braintelligence.projectmanager.team.base.SampleTeamMemberDto

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.OK
import static pl.braintelligence.projectmanager.team.base.SampleNewTeamDto.sampleNewTeamDto
import static pl.braintelligence.projectmanager.team.base.SampleTeamMemberDto.sampleTeamMemberDto

class TeamAcceptanceSpec extends BaseIntegrationSpec implements OperatingOnTeamEndpoint {

    def "Should go through team endpoint flow"() {
        when: "new team is created"
        def response = createNewTeam(sampleNewTeamDto())

        then: "system response - team is created"
        response.statusCode == CREATED

        when: "user asks for all created teams"
        response = getExistingTeams()

        then: "checks that one team was created and has default settings"
        response.statusCode == OK

        when: "member is added to a team"
        response = addMemberToTeam(sampleTeamMemberDto(), sampleNewTeamDto())

        then: "system response - member is added"
        response.statusCode == CREATED

        when: "user asks again for all created teams"
        response = getExistingTeams()

        then: "checks that member was added"
        response.statusCode == OK
        response.body[0].members[0] == SampleTeamMemberDto.TEAM_MEMBER_DTO
    }
}
