package pl.braintelligence.projectmanager.application.dto

import pl.braintelligence.projectmanager.domain.values.Employee

data class TeamMember(
    val firstName: String,
    val lastName: String,
    val jobPosition: String
) {
    companion object {
        fun toTeamMembers(members: List<Employee>): List<TeamMember> =
            members.map { mapToTeamMember(it) }

        fun mapToTeamMember(employee: Employee): TeamMember =
            TeamMember(
                employee.firstName,
                employee.lastName,
                employee.jobPosition.toString()
            )
    }
}
