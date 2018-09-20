package pl.braintelligence.projectmanager.domain.values

import org.apache.commons.lang3.StringUtils.isBlank
import pl.braintelligence.projectmanager.application.dto.TeamMember

data class Employee(
    val firstName: String,
    val lastName: String,
    val jobPosition: JobPosition
) {

    fun hasNoFirstName(): Boolean = isBlank(firstName)

    fun hasNoLastName(): Boolean = isBlank(lastName)

    fun hasInvalidJobPosition(): Boolean = jobPosition.isInvalid()

    companion object {
        fun toEmployee(teamMember: TeamMember) =
            Employee(
                teamMember.firstName,
                teamMember.lastName,
                toJobPosition(teamMember.jobPosition)
            )

        fun toJobPosition(jobPosition: String): JobPosition {
            return try {
                JobPosition.valueOf(jobPosition)
            } catch (e: IllegalArgumentException) {
                JobPosition.INVALID
            }
        }
    }
}
