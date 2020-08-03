package pl.braintelligence.projectmanager.core.projects.domain.values

import arrow.core.Try
import arrow.core.getOrElse
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.project.dto.NewFeature

class Feature(
        val name: String,
        val status: Status = Status.TO_DO,
        val priorityLevel: PriorityLevel = PriorityLevel.NOT_DEFINED
) {

    fun hasNoBlankName() = name.isNotBlank()
    fun hasValidStatus() = status != Status.INVALID
    fun hasValidPriorityLevel() = priorityLevel != PriorityLevel.INVALID

    companion object {
        fun toFeatures(newFeatures: List<NewFeature>) =
                newFeatures.map {
                    Feature(
                            it.name,
                            validateStatus(it),
                            validatePriorityLevel(it)
                    )
                }

        private fun validatePriorityLevel(it: NewFeature) = Try {
            PriorityLevel.valueOf(it.priorityLevel)
        }.getOrElse { PriorityLevel.INVALID }

        private fun validateStatus(it: NewFeature) = Try {
            Status.valueOf(it.status)
        }.getOrElse { Status.INVALID }
    }
}
