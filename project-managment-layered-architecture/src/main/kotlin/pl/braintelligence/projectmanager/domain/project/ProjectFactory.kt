package pl.braintelligence.projectmanager.domain.project

import org.springframework.stereotype.Component
import pl.braintelligence.projectmanager.domain.services.UniqueIdentifierGenerator

@Component
class ProjectFactory(
    private val identifierGenerator: UniqueIdentifierGenerator
) {
    fun createProjectDraft(name: String): Project {
        val id = identifierGenerator.generateUniqueIdentifier()
        return Project(id, name)
    }
}