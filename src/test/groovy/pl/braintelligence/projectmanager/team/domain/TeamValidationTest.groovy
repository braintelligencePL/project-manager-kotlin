package pl.braintelligence.projectmanager.team.domain

import pl.braintelligence.projectmanager.base.BaseUnitTest
import pl.braintelligence.projectmanager.core.team.domain.EntityAlreadyExistsException
import pl.braintelligence.projectmanager.core.team.domain.InvalidTeamException
import pl.braintelligence.projectmanager.core.team.domain.MissingTeamException
import pl.braintelligence.projectmanager.core.team.domain.Team

class TeamValidationTest extends BaseUnitTest {

    def "Should throw exception when team does not exist"() {
        when:
        teamService.addMemberToTeam("non-existent team name", teamMemberDto)

        then:
        def thrown = thrown(MissingTeamException.class)
        thrown.message == "Team does not exist."
    }

    def "Should throw an exception when team name is empty"() {
        when:
        new Team(teamName)

        then:
        def ex = thrown(InvalidTeamException.class)
        ex.message == "Empty team name."

        where:
        teamName << ['', ' ']
    }

    def "Should not create team that already exists"() {
        given: "create a team"
        teamService.createTeam(newTeamDto)

        when: "create another team with the same name"
        teamService.createTeam(newTeamDto)

        then:
        def thrown = thrown(EntityAlreadyExistsException.class)
        thrown.message == "Team already exist."
    }
}
