package pl.braintelligence.projectmanager.domain.values

import pl.braintelligence.projectmanager.application.dto.NewFeatureDto

data class Feature(
    val name: String,
    val status: Status = Status.TO_DO,
    val requirement: Requirement
) {
    companion object {
        fun toFeatures(newFeatureDto: List<NewFeatureDto>): List<Feature> =
                newFeatureDto.map { toFeature(it) }

        fun toFeature(newFeatureDto: NewFeatureDto): Feature =
                Feature(
                    name = newFeatureDto.name,
                    requirement = Requirement.valueOf(newFeatureDto.requirement)
                )
    }
}
