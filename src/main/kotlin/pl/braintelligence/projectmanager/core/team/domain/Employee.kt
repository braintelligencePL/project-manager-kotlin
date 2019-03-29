package pl.braintelligence.projectmanager.core.team.domain

import pl.braintelligence.projectmanager.adapter.TeamMember

class Employee(
        val firstName: String,
        val lastName: String,
        val position: JobPosition
) {
    fun hasNoFirstName(): Boolean = firstName.isNotBlank()
    fun hasNoLastName(): Boolean = lastName.isNotBlank()

    companion object {
        fun toEmployee(teamMember: TeamMember): Employee =
                Employee(
                        teamMember.firstName,
                        teamMember.lastName,
                        JobPosition.valueOf(teamMember.jobPosition)
                )
    }
}
