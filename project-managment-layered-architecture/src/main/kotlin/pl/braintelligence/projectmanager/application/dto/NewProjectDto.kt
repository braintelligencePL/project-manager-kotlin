package pl.braintelligence.projectmanager.application.dto

data class NewProjectDto(
    val name: String,
    val features: List<NewFeatureDto>
)
