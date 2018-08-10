package pl.braintelligence.projectmanager.domain

import pl.braintelligence.projectmanager.domain.values.Employee

data class Team(
        val name: String,
        val currentlyImplementedProjects: Int = 0,
        val members: List<Employee> = emptyList())