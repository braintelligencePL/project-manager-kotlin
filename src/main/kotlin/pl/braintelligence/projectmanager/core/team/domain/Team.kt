package pl.braintelligence.projectmanager.core.team.domain

data class Team @JvmOverloads constructor(
        val name: String,
        val currentlyImplementedProjects: Int = 0,
        var members: List<Employee> = listOf()
) {
    init {
        require(name.isNotBlank()) { throw InvalidTeamException("Empty team name.") }
    }

    fun addMember(teamMember: Employee) {
        validateMember(teamMember)
        members = members.plus(teamMember)
    }

    fun isTeamBusy(): Boolean = currentlyImplementedProjects > BUSY_TEAM_THRESHOLD

    private fun validateMember(teamMember: Employee) {
        require(teamMember.hasNoFirstName()) { throw InvalidTeamMemberException("Empty member first name.") }
        require(teamMember.hasNoLastName()) { throw InvalidTeamMemberException("Empty member last name.") }
        require(teamMember.hasInvalidJobPosition()) { throw InvalidTeamMemberException("Invalid job position.") }
    }

    companion object {
        const val BUSY_TEAM_THRESHOLD = 3
    }
}
