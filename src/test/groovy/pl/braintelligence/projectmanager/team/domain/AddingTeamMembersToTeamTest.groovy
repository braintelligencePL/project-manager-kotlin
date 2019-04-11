package pl.braintelligence.projectmanager.team.domain


import pl.braintelligence.projectmanager.team.base.BaseTeamUnitTest

class AddingTeamMembersToTeamTest extends BaseTeamUnitTest {

    def "Should add member to a team"() {
        given: "new team is created"
        teamService.createTeam(newTeamDto)

        and: "member is added to a team"
        teamService.addMemberToTeam(newTeamDto.name, teamMemberDto)

        when: "teams are retrieved"
        def response = teamService.getTeam(newTeamDto.name)

        then: "new member is in a team"
        with(response.members[0]) {
            firstName == teamMemberDto.firstName
            lastName == teamMemberDto.lastName
            jobPosition.name() == teamMemberDto.jobPosition
        }
    }

}
