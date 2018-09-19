package pl.braintelligence.projectmanager.domain.project

import pl.braintelligence.projectmanager.domain.services.UniqueIdentifierGenerator

class ProjectFactory(
    val identifierGenerator: UniqueIdentifierGenerator
) {
    fun createProjectDraft(name: String): Project {
        val id = identifierGenerator.generateUniqueIdentifier()
        //TODO
    }
}