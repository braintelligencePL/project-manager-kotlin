package pl.braintelligence.projectmanager.core.team.domain

import pl.braintelligence.projectmanager.core.team.domain.values.Employee

data class Team @JvmOverloads constructor(
        val name: String,
        var numberOfOngoingProjects: Int = 0,
        var members: List<Employee> = listOf()
) {
    init {
        require(name.isNotBlank()) { throw InvalidTeamException("Empty teamName name.") }
    }

    fun addMember(teamMember: Employee) {
        validateMember(teamMember)
        members = members.plus(teamMember)
    }

    private fun validateMember(teamMember: Employee) {
        require(teamMember.hasNoFirstName()) { throw InvalidTeamMemberException("Empty member first name.") }
        require(teamMember.hasNoLastName()) { throw InvalidTeamMemberException("Empty member last name.") }
        require(teamMember.hasInvalidJobPosition()) { throw InvalidTeamMemberException("Invalid job position.") }
    }

    fun isTeamBusy(): Boolean = numberOfOngoingProjects > BUSY_TEAM_THRESHOLD
    fun incrementOngoingTeamProjects() = numberOfOngoingProjects++

    companion object {
        const val BUSY_TEAM_THRESHOLD = 3
    }
}
