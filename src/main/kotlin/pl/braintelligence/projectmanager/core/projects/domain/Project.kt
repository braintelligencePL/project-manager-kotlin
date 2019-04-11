package pl.braintelligence.projectmanager.core.projects.domain

data class Project(
        val id: String,
        val name: String,
        val status: Status = Status.TO_DO,
        val teamAssigned: String = "",
        val features: List<Feature> = listOf()
)
