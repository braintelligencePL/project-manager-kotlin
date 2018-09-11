package pl.braintelligence.projectmanager.domain.values

import org.apache.commons.lang3.StringUtils.isBlank
import pl.braintelligence.projectmanager.application.dto.TeamMemberDto
import java.util.Arrays

data class Employee(
    val firstName: String,
    val lastName: String,
    val jobPosition: JobPosition
) {
    fun hasNoFirstName(): Boolean = isBlank(firstName)

    companion object {
        fun toEmployee(teamMemberDto: TeamMemberDto) =
            Employee(
                teamMemberDto.firstName,
                teamMemberDto.lastName,
                toJobPosition(teamMemberDto.jobPosition)
            )

        fun toJobPosition(position: String): JobPosition {
            return JobPosition.DEVELOPER //TODO:
        }
    }
}

enum class JobPosition {
    DEVELOPER,
    SCRUM_MASTER,
    PRODUCT_OWNER,
    INVALID;
}
