package pl.braintelligence.projectmanager.application.dto

import pl.braintelligence.projectmanager.domain.values.Employee

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