package pl.braintelligence.projectmanager.base


import pl.braintelligence.projectmanager.adapter.NewTeam
import pl.braintelligence.projectmanager.adapter.TeamMember
import spock.lang.Specification

class BaseUnitTest extends Specification {

    def newTeamDto = new NewTeam("123")

    def teamMemberDto = new TeamMember(
            "firstName",
            "LastName",
            "DEVELOPER"
    )
}
