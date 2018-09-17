package pl.braintelligence.projectmanager.domain.team

import org.apache.commons.lang3.StringUtils.isBlank
import pl.braintelligence.projectmanager.domain.exceptions.InvalidEntityException
import pl.braintelligence.projectmanager.domain.exceptions.ErrorCode.*
import pl.braintelligence.projectmanager.domain.values.Employee

data class Team(
    val name: String,
    val currentProjects: Int = 0,
    var members: MutableList<Employee> = mutableListOf()
) {

    init {
        validateName(name)
    }

    fun addMember(teamMember: Employee) {
        validateMember(teamMember)
        members.add(teamMember)
    }

    private fun validateName(name: String) {
        when (isBlank(name)) {
            true -> throw InvalidEntityException(EMPTY_TEAM_NAME)
        }
    }

    private fun validateMember(teamMember: Employee) {
        if (teamMember.hasNoFirstName())
            throw InvalidEntityException(EMPTY_MEMBER_FIRST_NAME)
        if (teamMember.hasNoLastName())
            throw InvalidEntityException(EMPTY_MEMBER_LAST_NAME)
        if (teamMember.hasInvalidJobPosition())
            throw InvalidEntityException(EMPTY_OR_INVALID_JOB_POSITION)
    }

    fun isBusy(): Boolean = currentProjects > THRESHOLD_BUSY_TEAM

    companion object {
        private const val THRESHOLD_BUSY_TEAM = 3
    }
}