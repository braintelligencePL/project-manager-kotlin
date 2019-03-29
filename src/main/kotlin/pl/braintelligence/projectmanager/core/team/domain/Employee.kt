package pl.braintelligence.projectmanager.core.team.domain

import arrow.core.Try
import arrow.core.getOrElse
import pl.braintelligence.projectmanager.adapter.TeamMember

class Employee(
        val firstName: String,
        val lastName: String,
        val jobPosition: JobPosition
) {
    fun hasNoFirstName(): Boolean = firstName.isNotBlank()
    fun hasNoLastName(): Boolean = lastName.isNotBlank()
    fun hasInvalidJobPosition(): Boolean = jobPosition.isValid()

    companion object {
        fun mapToEmployee(teamMember: TeamMember): Employee =
                Employee(
                        teamMember.firstName,
                        teamMember.lastName,
                        toJobPosition(teamMember)
                )

        private fun toJobPosition(teamMember: TeamMember) = Try {
            JobPosition.valueOf(teamMember.jobPosition)
        }.getOrElse { JobPosition.INVALID }

    }
}
