package pl.braintelligence.projectmanager.core.projects.domain

data class Project(
        val id: String,
        val name: String,
        val status: ProjectStatus = ProjectStatus.TO_DO,
        val teamAssigned: String = ""
)
