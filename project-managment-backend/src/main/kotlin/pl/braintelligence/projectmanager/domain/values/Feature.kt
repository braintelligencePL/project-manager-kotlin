package pl.braintelligence.projectmanager.domain.values

import org.apache.commons.lang3.StringUtils.isBlank
import pl.braintelligence.projectmanager.api.project.dto.NewFeature

data class Feature(
        val name: String,
        val status: Status = Status.TO_DO,
        val requirement: Requirement
) {

    fun hasInvalidRequirement(): Boolean = requirement.isInvalid()
    fun hasNoStatus(): Boolean = isBlank(status.toString())
    fun hasNoRequirement(): Boolean = isBlank(requirement.toString())

    companion object {
        fun toFeatures(newFeature: List<NewFeature>): List<Feature> =
                newFeature.map { toFeature(it) }

        private fun toFeature(newFeature: NewFeature): Feature =
                Feature(
                        name = newFeature.name,
                        requirement = checkRequirement(newFeature.requirement)
                )

        private fun checkRequirement(requirement: String): Requirement {
            return try {
                Requirement.valueOf(requirement)
            } catch (e: IllegalArgumentException) {
                Requirement.INVALID
            }
        }
    }

}
