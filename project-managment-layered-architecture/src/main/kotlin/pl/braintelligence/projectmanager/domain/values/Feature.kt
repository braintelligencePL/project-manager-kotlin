package pl.braintelligence.projectmanager.domain.values

import pl.braintelligence.projectmanager.application.dto.NewFeature

data class Feature(
    val name: String,
    val status: Status = Status.TO_DO,
    val requirement: Requirement
) {
    companion object {
        fun toFeatures(newFeature: List<NewFeature>): List<Feature> =
                newFeature.map { toFeature(it) }

        fun toFeature(newFeature: NewFeature): Feature =
                Feature(
                    name = newFeature.name,
                    requirement = newFeature.requirement
                )
    }
}
