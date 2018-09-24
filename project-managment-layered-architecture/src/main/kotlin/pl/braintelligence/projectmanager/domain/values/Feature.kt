package pl.braintelligence.projectmanager.domain.values

import org.apache.commons.lang3.StringUtils.isBlank
import pl.braintelligence.projectmanager.application.dto.NewFeatureDto

data class Feature(
        val name: String,
        val status: Status = Status.TO_DO,
        val requirement: Requirement
) {

    fun isUnnamed(): Boolean = isBlank(name)
    fun hasNoStatus(): Boolean = isBlank(status.toString())
    fun hasNoRequirement(): Boolean = isBlank(requirement.toString())

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
