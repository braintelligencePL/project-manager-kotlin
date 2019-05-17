package pl.braintelligence.projectmanager.team.domain

import pl.braintelligence.projectmanager.team.base.BaseTeamSetupUnitTest

class TeamUnitTestCreationTest extends BaseTeamSetupUnitTest {

    def "Should create multiple teams (with default values)"() {
        given:
        teamService.createTeam(newTeamDto)

        when:
        def response = teamService.getTeam(newTeamDto.name)

        then: "teamName has default settings"
        with(response) {
            name == newTeamDto.name
            numberOfOngoingProjects == 0
            members == []
        }

        when: "another teamName is created"
        teamService.createTeam(newTeamDto1)

        and: "getting all teams"
        response = teamService.getTeams()

        then: "two teams are created"
        with(response) {
            name[0] == newTeamDto.name
            name[1] == newTeamDto1.name
        }

    }
}
