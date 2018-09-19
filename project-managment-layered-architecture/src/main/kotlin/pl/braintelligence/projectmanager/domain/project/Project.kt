package pl.braintelligence.projectmanager.domain.project

import org.apache.commons.lang3.StringUtils.isBlank
import org.springframework.data.annotation.Id
import pl.braintelligence.projectmanager.domain.exceptions.ErrorCode
import pl.braintelligence.projectmanager.domain.exceptions.InvalidEntityException
import pl.braintelligence.projectmanager.domain.values.Status

data class Project(
    @Id val id: String,
    val name: String,
    val status: Status = Status.TO_DO,
    val assignedTeam: String? = null
) {
    init {
        validateIdentifier()
        validateName()
    }

    private fun validateIdentifier() {
        if(isBlank(id))
            throw InvalidEntityException(ErrorCode.EMPTY_PROJECT_IDENTIFIER)
    }

    private fun validateName() {
        if(isBlank(name))
            throw InvalidEntityException(ErrorCode.EMPTY_PROJECT_NAME)
    }

}
