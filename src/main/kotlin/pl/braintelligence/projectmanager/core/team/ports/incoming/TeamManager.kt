package pl.braintelligence.projectmanager.core.team.ports.incoming

import pl.braintelligence.projectmanager.core.team.domain.Team
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.team.NewTeam
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.team.TeamMember

/**
 * Primary Port
 */

interface TeamManager {

    fun createTeam(newTeam: NewTeam): Team

    fun addMemberToTeam(teamName: String, teamMember: TeamMember)

    fun getTeams(): List<Team>

    fun getTeam(teamName: String): Team

}
