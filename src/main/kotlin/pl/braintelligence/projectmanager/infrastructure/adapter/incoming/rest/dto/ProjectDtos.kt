package pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto

import pl.braintelligence.projectmanager.core.projects.domain.Feature

data class ProjectDraft(val name: String)

data class ProjectWithFeatures(val name: String, val features: List<Feature>)
