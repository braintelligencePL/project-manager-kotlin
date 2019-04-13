package pl.braintelligence.projectmanager.core.projects.domain

import org.apache.commons.lang3.StringUtils.trimToNull
import pl.braintelligence.projectmanager.core.projects.domain.values.Feature
import pl.braintelligence.projectmanager.core.projects.domain.values.Status

data class Project @JvmOverloads constructor(
        val id: String,
        var name: String,
        val status: Status = Status.TO_DO,
        var teamAssigned: String = "",
        var features: List<Feature> = listOf()
) {
    init {
        require(id.isNotBlank()) { throw InvalidProjectException("Project id cannot be empty.") }
        validateName(name)
        validateFeatures(features)
    }

    fun changeProjectName(name: String) {
        validateName(name)
        this.name = name
    }

    fun changeProjectFeatures(featuresToUpdate: List<Feature>) {
        validateFeatures(featuresToUpdate)
        this.features = featuresToUpdate
    }

    fun assignTeam(team: String) {
        this.teamAssigned = trimToNull(team)
    }

    private fun validateName(name: String) = require(name.isNotBlank()) {
        throw InvalidProjectException("Project name cannot be empty.")
    }

    private fun validateFeatures(features: List<Feature>) {
        features.forEach {
            require(it.hasNoBlankName()) { throw InvalidProjectFeatureException("Project feature must have a name.") }
            require(it.hasValidStatus()) { throw InvalidProjectFeatureException("Project feature must have valid status.") }
            require(it.hasValidPriorityLevel()) { throw InvalidProjectFeatureException("Project feature must have valid priority level.") }
        }
    }
}
