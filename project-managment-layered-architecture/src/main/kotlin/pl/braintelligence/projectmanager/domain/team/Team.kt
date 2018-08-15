package pl.braintelligence.projectmanager.domain.team

import pl.braintelligence.projectmanager.domain.values.Employee

data class Team(
        val name: String,
        val currentlyImplementedProjects: Int = 0,
        val members: List<Employee> = emptyList())