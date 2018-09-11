package pl.braintelligence.projectmanager.integration.team

import pl.braintelligence.projectmanager.integration.team.base.OperatingOnTeamEndpoint
import pl.braintelligence.projectmanager.integration.base.BaseIntegrationSpec

import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.CREATED
import static pl.braintelligence.projectmanager.integration.team.base.SampleNewTeamDto.sampleNewTeamDto
import static pl.braintelligence.projectmanager.integration.team.base.SampleTeamMemberDto.sampleTeamMemberDto
import static pl.braintelligence.projectmanager.integration.team.base.SampleTeamMemberDto.TEAM_MEMBER_DTO

class TeamAcceptanceSpec extends BaseIntegrationSpec implements OperatingOnTeamEndpoint {

    def "Should create team and add member to it "() {
        when: "new team is created"
        def response = createNewTeam(sampleNewTeamDto())

        then: "system response - team is created"
        response.statusCode == CREATED

        when: "user asks for all created teams"
        response = getExistingTeams()

        then: "checks that one team was created and has default settings"
        response.statusCode == OK
        response.body.size() == 1

        response.body[0].name == sampleNewTeamDto().name
        response.body[0].currentlyImplementedProjects == 0
        response.body[0].busy == false
        response.body[0].members == []

        when: "member is added to a team"
        response = addMemberToTeam(sampleTeamMemberDto(), sampleNewTeamDto())

        then: "system response - member is added"
        response.statusCode == CREATED

        when: "user asks again for all created teams"
        response = getExistingTeams()

        then:
        response.body[0].members[0] == TEAM_MEMBER_DTO
    }
}


