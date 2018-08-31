package pl.braintelligence.projectmanager.domain.values

import pl.braintelligence.projectmanager.application.dto.TeamMemberDto
import java.util.Arrays

data class Employee(
    val firstName: String,
    val lastName: String,
    val jobPosition: JobPosition
) {
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
