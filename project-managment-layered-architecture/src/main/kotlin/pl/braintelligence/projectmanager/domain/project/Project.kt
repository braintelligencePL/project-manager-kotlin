package pl.braintelligence.projectmanager.domain.project

import org.apache.commons.lang3.StringUtils.isBlank
import org.springframework.data.annotation.Id
import pl.braintelligence.projectmanager.domain.exceptions.ErrorCode
import pl.braintelligence.projectmanager.domain.exceptions.InvalidEntityException
import pl.braintelligence.projectmanager.domain.values.Feature
import pl.braintelligence.projectmanager.domain.values.Status
import java.util.function.Consumer

class Project(
        @Id val id: String,
        val name: String,
        val status: Status = Status.TO_DO,
        val assignedTeam: String? = null,
        var features: List<Feature>? = null
) {
    init {
        validateIdentifier(id)
        validateName(name)
        features = normalize(features)
        validateFeatures(features)
    }

    private fun validateIdentifier(id: String) {
        if (isBlank(id))
            throw InvalidEntityException(ErrorCode.EMPTY_PROJECT_ID)
    }

    private fun validateName(name: String) {
        if (isBlank(name))
            throw InvalidEntityException(ErrorCode.EMPTY_PROJECT_NAME)
    }

    private fun normalize(features: List<Feature>?): List<Feature>? {
        return when {
            features?.isEmpty() == true -> emptyList()
            else -> features
        }
    }

    private fun validateFeatures(features: List<Feature>?) {
        features?.forEach(Consumer<Feature> { this.validateFeature(it) })
    }

    private fun validateFeature(feature: Feature) {
        if (feature.isUnnamed())
            throw InvalidEntityException(ErrorCode.EMPTY_FEATURE)
        if (feature.hasNoStatus())
            throw InvalidEntityException(ErrorCode.EMPTY_FEATURE_STATUS)
        if (feature.hasNoRequirement())
            throw InvalidEntityException(ErrorCode.EMPTY_FEATURE_REQUIREMENT)
    }
}
