package pl.braintelligence.projectmanager.domain.team

import org.apache.commons.lang3.StringUtils.isBlank
import pl.braintelligence.projectmanager.domain.exceptions.InvalidTeamException
import pl.braintelligence.projectmanager.domain.values.Employee

class Team(
        val name: String,
        val currentlyImplementedProjects: Int = 0,
        val members: List<Employee> = emptyList()
) {
    init {
//        validateName(name)
    }

    private fun validateName(name: String) {
        when(isBlank(name)) {
            true -> throw InvalidTeamException("Empty team name.")
        }
    }
}