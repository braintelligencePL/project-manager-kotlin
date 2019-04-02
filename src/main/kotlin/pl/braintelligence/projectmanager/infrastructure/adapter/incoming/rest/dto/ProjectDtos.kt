package pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto

import pl.braintelligence.projectmanager.core.projects.domain.Feature

data class ProjectDraft(val projectName: String)

data class ProjectWithFeatures(val projectName: String, val features: List<Feature>)
