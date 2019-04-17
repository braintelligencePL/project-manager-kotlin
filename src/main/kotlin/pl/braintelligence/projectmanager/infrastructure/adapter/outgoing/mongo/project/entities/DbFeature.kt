package pl.braintelligence.projectmanager.infrastructure.adapter.outgoing.mongo.project.entities

data class DbFeature(
        val name: String,
        val status: String,
        val priorityLevel: String
)
