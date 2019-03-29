package pl.braintelligence.projectmanager.core.ports.`in`

import pl.braintelligence.projectmanager.adapter.NewTeam
import pl.braintelligence.projectmanager.adapter.TeamMember
import pl.braintelligence.projectmanager.core.team.domain.Team

/**
 * Primary Port
 */

interface TeamManager {

    fun createTeam(newTeam: NewTeam)

    fun addMemberToTeam(teamName: String, teamMember: TeamMember)

    fun getTeams(): List<Team>

    fun getTeam(teamName: String): Team

}
