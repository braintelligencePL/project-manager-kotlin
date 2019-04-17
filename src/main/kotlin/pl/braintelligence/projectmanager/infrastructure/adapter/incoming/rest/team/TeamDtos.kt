package pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.team

import pl.braintelligence.projectmanager.core.team.domain.Team
import pl.braintelligence.projectmanager.core.team.domain.values.Employee

data class NewTeam(val name: String)

data class TeamMember(
        val firstName: String,
        val lastName: String,
        val jobPosition: String
) {
    companion object {
        fun toTeamMembers(employees: List<Employee>): List<TeamMember> =
                employees.map {
                    TeamMember(
                            it.firstName,
                            it.lastName,
                            it.jobPosition.toString())
                }
    }
}

data class ExistingTeam(
        val name: String,
        val currentlyImplementedProjects: Int,
        val members: List<TeamMember>,
        val isTeamBusy: Boolean
) {
    companion object {
        fun toExistingTeams(teams: List<Team>): List<ExistingTeam> =
                teams.map { toExistingTeam(it) }

        fun toExistingTeam(team: Team) = ExistingTeam(
                team.name,
                team.numberOfOngoingProjects,
                TeamMember.toTeamMembers(team.members),
                team.isTeamBusy())
    }
}
