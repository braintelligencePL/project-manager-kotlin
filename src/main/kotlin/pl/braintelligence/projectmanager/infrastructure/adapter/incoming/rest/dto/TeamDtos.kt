package pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto

import pl.braintelligence.projectmanager.core.team.domain.Employee
import pl.braintelligence.projectmanager.core.team.domain.Team

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
                teams.map {
                    ExistingTeam(
                            it.name,
                            it.numberOfOngoingProjects,
                            TeamMember.toTeamMembers(it.members),
                            it.isTeamBusy())
                }
    }
}
