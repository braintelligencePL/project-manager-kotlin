package pl.braintelligence.projectmanager.application.team.dto

import pl.braintelligence.projectmanager.domain.Team
import pl.braintelligence.projectmanager.domain.values.Employee

data class ExistingTeamDto(
        val teams: List<ExistingTeam>,
        val count: Int
) {
    companion object {
        fun mapToExistingTeams(teams: List<Team>, count: Int): ExistingTeamDto = ExistingTeamDto(
                teams.map { ExistingTeam.mapToExistingTeam(it) },
                count
        )
    }
}

data class ExistingTeam(
        val name: String,
        val currentlyImplementedProjects: Int,
        val busy: Boolean,
        val members: List<TeamMember>
) {
    companion object {
        fun mapToExistingTeam(team: Team): ExistingTeam =
                ExistingTeam(
                        team.name,
                        team.currentlyImplementedProjects,
                        false, //TODO
                        team.members.map { TeamMember.mapToTeamMember(it) }
                )
    }
}

data class TeamMember(
        val firstName: String,
        val lastName: String,
        val jobPosition: String
) {
    companion object {
        fun mapToTeamMember(employee: Employee): TeamMember =
                TeamMember(
                        employee.firstName,
                        employee.lastName,
                        employee.jobPosition.toString()
                )
    }
}