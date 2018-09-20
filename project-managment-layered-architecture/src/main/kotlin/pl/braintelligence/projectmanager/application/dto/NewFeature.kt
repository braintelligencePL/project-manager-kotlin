package pl.braintelligence.projectmanager.application.dto

import pl.braintelligence.projectmanager.domain.values.Requirement

data class NewFeature(
    val name: String,
    val requirement: Requirement
)
