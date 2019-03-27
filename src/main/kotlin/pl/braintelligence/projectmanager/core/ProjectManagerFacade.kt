package pl.braintelligence.projectmanager.core

import org.springframework.stereotype.Service
import pl.braintelligence.projectmanager.adapter.NewTeam
import pl.braintelligence.projectmanager.adapter.TeamMember
import pl.braintelligence.projectmanager.core.team.Team
import pl.braintelligence.projectmanager.core.team.TeamService

@Service
class ProjectManagerFacade(
        private val teamService: TeamService
) : ProjectManager {

    override fun createTeam(newTeam: NewTeam) =
            teamService.createTeam(newTeam.name)

    override fun addMemberToTeam(teamName: String, teamMember: TeamMember) {
        teamService.addMemberToTeam(teamName, teamMember)
    }

    override fun getTeams(): List<Team> {
        return teamService.getTeams()
    }
}
