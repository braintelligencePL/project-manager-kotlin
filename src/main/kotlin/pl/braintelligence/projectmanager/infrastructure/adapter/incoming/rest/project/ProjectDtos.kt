package pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.project

data class ProjectDraft(val projectName: String)

data class ProjectWithFeatures(val projectName: String, val features: List<NewFeature>)

data class NewFeature(val name: String, val status: String, val priorityLevel: String)

data class UpdateProject(val name: String, val teamName: String, val features: List<NewFeature>)

data class ProjectEndCondition(val requiredFeaturesDone: Boolean)
