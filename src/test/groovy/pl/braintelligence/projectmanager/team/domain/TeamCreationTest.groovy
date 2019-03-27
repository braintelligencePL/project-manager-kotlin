package pl.braintelligence.projectmanager.team.domain

import pl.braintelligence.projectmanager.base.BaseUnitTest
import pl.braintelligence.projectmanager.core.team.Team

class TeamCreationTest extends BaseUnitTest {

    def "Should create a team"() {
        given:
        def teamName = "valid team name"

        when:
        def team = new Team(teamName)

        then:
        team != null
    }

    def "Should throw an exception when team name is empty"() {
        when:
        new Team(teamName)

        then:
        def ex = thrown(IllegalArgumentException.class)
        ex.message == "Empty team name."

        where:
        teamName << ['', ' ']
    }

    def "Should not create team that already exists"() {

    }

}
