package pl.braintelligence.projectmanager.team.domain


import pl.braintelligence.projectmanager.team.base.BaseTeamSetupUnitTest

class TeamMembersAddedToTeamUnitTestTest extends BaseTeamSetupUnitTest {

    def "Should add member to a team"() {
        given: "new teamName is created"
        teamService.createTeam(newTeamDto)

        and: "member is added to a teamName"
        teamService.addMemberToTeam(newTeamDto.name, teamMemberDto)

        when: "teams are retrieved"
        def response = teamService.getTeam(newTeamDto.name)

        then: "new member is in a teamName"
        with(response.members[0]) {
            firstName == teamMemberDto.firstName
            lastName == teamMemberDto.lastName
            jobPosition.name() == teamMemberDto.jobPosition
        }
    }

}
