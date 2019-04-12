package pl.braintelligence.projectmanager.core.projects.domain

import pl.braintelligence.projectmanager.core.projects.domain.values.Feature
import pl.braintelligence.projectmanager.core.projects.domain.values.Status

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
        validateFeatures()
    }

    private fun validateFeatures() {
        features.forEach {
            require(it.hasNoBlankName()) { throw InvalidProjectFeatureException("Project feature must have a name.") }
            require(it.hasValidStatus()) { throw InvalidProjectFeatureException("Project feature must have valid status.") }
            require(it.hasValidPriorityLevel()) { throw InvalidProjectFeatureException("Project feature must have valid priority level.") }
        }
    }

}
