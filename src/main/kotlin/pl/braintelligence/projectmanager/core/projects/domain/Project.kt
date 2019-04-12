package pl.braintelligence.projectmanager.core.projects.domain

data class Project @JvmOverloads constructor(
        val id: String,
        val name: String,
        val status: Status = Status.TO_DO,
        val teamAssigned: String = "",
        val features: List<Feature> = listOf()
) {
    init {
        require(id.isNotBlank()) { throw InvalidProjectException("Project id cannot be empty.") }
        require(name.isNotBlank()) { throw InvalidProjectException("Project name cannot be empty.") }
        validateFeatures(features)
    }

    private fun validateFeatures(features: List<Feature>) {
        features.forEach {
            require(it.hasNoBlankName()) { throw InvalidProjectFeatureException("Project feature must have a name.") }
        }
    }

}
