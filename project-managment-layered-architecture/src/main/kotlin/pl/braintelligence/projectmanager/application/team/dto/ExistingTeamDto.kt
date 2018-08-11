package pl.braintelligence.projectmanager.application.team.dto

import pl.braintelligence.projectmanager.domain.Team
import pl.braintelligence.projectmanager.domain.values.Employee

data class ExistingTeamDto(
        val name: String,
        val currentlyImplementedProjects: Int,
        val busy: Boolean,
        val members: List<TeamMemberDto>
) {
    companion object {
        fun mapToExistingTeams(teams: List<Team>): List<ExistingTeamDto> =
                teams.map {
                    ExistingTeamDto(
                            it.name,
                            it.currentlyImplementedProjects,
                            true, //TODO:
                            TeamMemberDto.toTeamMembers(it.members)
                    )
                }
    }
}

data class TeamMemberDto(
        val firstName: String,
        val lastName: String,
        val jobPosition: String
) {
    companion object {
        fun toTeamMembers(members: List<Employee>): List<TeamMemberDto> =
                members.map { mapToTeamMember(it) }

        fun mapToTeamMember(employee: Employee): TeamMemberDto =
                TeamMemberDto(
                        employee.firstName,
                        employee.lastName,
                        employee.jobPosition.toString()
                )
    }
}