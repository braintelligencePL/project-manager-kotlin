package pl.braintelligence.projectmanager.core.projects.domain

import org.springframework.stereotype.Component
import java.util.*

@Component
open class ProjectFactory {

    fun createProjectDraft(projectName: String): Project {
        val id = generateProjectUniqueId()
        return Project(id = id, name = projectName)
    }

    fun createProjectWithFeatures(name: String, features: List<Feature>): Project {
        val id = generateProjectUniqueId()
        return Project(id = id, name = name, features = features)
    }

    private fun generateProjectUniqueId() = UUID.randomUUID().toString()
}
