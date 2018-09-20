package pl.braintelligence.projectmanager.application.dto

data class NewProject(
    val name: String,
    val features: List<NewFeature>
)
