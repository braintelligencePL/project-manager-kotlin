package pl.braintelligence.projectmanager.api.project.dto

data class NewProject(
        val name: String,
        val features: List<NewFeature>
)
