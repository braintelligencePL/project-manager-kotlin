package pl.braintelligence.projectmanager.core

import pl.braintelligence.projectmanager.adapter.NewTeam
import pl.braintelligence.projectmanager.adapter.TeamMember
import pl.braintelligence.projectmanager.core.team.Team

interface ProjectManager {

    fun createTeam(newTeam: NewTeam)

    fun addMemberToTeam(teamName: String, teamMember: TeamMember)

    fun getTeams(): List<Team>

}
