package pl.braintelligence.projectmanager.adapter

import pl.braintelligence.projectmanager.core.team.domain.Employee
import pl.braintelligence.projectmanager.core.team.domain.Team

data class NewTeam(val name: String)

data class TeamMember(val firstName: String, val lastName: String, val jobPosition: String)

data class ExistingTeam(
        val name: String,
        val currentlyImplementedProjects: Int,
        val members: List<Employee>,
        val isTeamBusy: Boolean
) {
    companion object {
        fun toExistingTeams(teams: List<Team>): List<ExistingTeam> =
                teams.map { toExistingTeam(it) }

        private fun toExistingTeam(team: Team): ExistingTeam =
                ExistingTeam(
                        team.name,
                        team.currentlyImplementedProjects,
                        team.members,
                        team.isTeamBusy()
                )

    }
}
