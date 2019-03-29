package pl.braintelligence.projectmanager.core.team.domain

import pl.braintelligence.projectmanager.core.team.exception.InvalidTeamException
import pl.braintelligence.projectmanager.core.team.exception.InvalidTeamMemberException

data class Team @JvmOverloads constructor(
        val name: String,
        val currentlyImplementedProjects: Int = 0,
        var members: List<Employee> = listOf()
) {
    init {
        require(name.isNotBlank()) { throw InvalidTeamException("Empty team name.") }
    }

    fun addMember(teamMember: Employee) {
        require(teamMember.hasNoFirstName()) { throw InvalidTeamMemberException("Empty member first name.") }
        require(teamMember.hasNoLastName()) { throw InvalidTeamMemberException("Empty member last name.") }
        members = members.plus(teamMember)
    }
}
