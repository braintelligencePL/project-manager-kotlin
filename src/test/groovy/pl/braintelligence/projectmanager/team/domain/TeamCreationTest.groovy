package pl.braintelligence.projectmanager.team.domain

import pl.braintelligence.projectmanager.team.base.BaseTeamUnitTest

class TeamCreationTest extends BaseTeamUnitTest {

    def "Should create a team (with default values)"() {
        given:
        teamService.createTeam(newTeamDto)

        when:
        def response = teamService.getTeam(newTeamDto.name)

        then:
        with(response) {
            name == newTeamDto.name
            numberOfOngoingProjects == 0
            members == []
        }
    }

    def "Should create a teams (with default values)"() {
        given:
        teamService.createTeam(newTeamDto)
        teamService.createTeam(newTeamDto1)

        when:
        def response = teamService.getTeams()

        then:
        with(response) {
            name[0] == newTeamDto.name
            name[1] == newTeamDto1.name
        }
    }

}
