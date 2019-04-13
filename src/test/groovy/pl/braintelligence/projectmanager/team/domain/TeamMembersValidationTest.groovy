package pl.braintelligence.projectmanager.team.domain


import pl.braintelligence.projectmanager.core.team.domain.InvalidTeamMemberException
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.team.TeamMember
import pl.braintelligence.projectmanager.team.base.BaseTeamUnitTest
import spock.lang.Unroll

class TeamMembersValidationTest extends BaseTeamUnitTest {

    def "Should add member to a team"() {
        given: "teamName is created"
        def teamName = newTeamDto.name
        teamService.createTeam(newTeamDto)

        when: "two members are added to a teamName"
        teamService.addMemberToTeam(teamName, teamMemberDto)
        teamService.addMemberToTeam(teamName, teamMemberDto)

        then: "two members are in a teamName"
        teamService.getTeam(teamName).members.size() == 2
    }

    @Unroll
    def "Should throw IllegalArgumentException when #errorMessage"() {
        given:
        def teamMember = new TeamMember(firstName, lastName, jobPosition)
        teamService.createTeam(newTeamDto)

        when:
        teamService.addMemberToTeam(newTeamDto.name, teamMember)

        then:
        def thrown = thrown(InvalidTeamMemberException.class)
        thrown.message == errorMessage

        where:
        errorMessage               | firstName          | lastName          | jobPosition
        "Empty member first name." | '   '              | 'valid last name' | 'DEVELOPER'
        "Empty member last name."  | 'valid first name' | '    '            | 'DEVELOPER'
        "Invalid job position."    | 'valid first name' | 'valid last name' | 'upps! not valid'
    }
}
