package pl.braintelligence.projectmanager.core.projects.domain

import org.springframework.stereotype.Component
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.ProjectWithFeatures
import java.util.*

@Component
open class ProjectFactory {

    fun createProjectDraft(projectName: String): Project {
        val id = generateProjectUniqueId()
        return Project(id, projectName)
    }

    fun createProjectWithFeatures(projectWithFeatures: ProjectWithFeatures): Project {
        val id = generateProjectUniqueId()
        val name = projectWithFeatures.name
        val features = projectWithFeatures.features

        return Project(id = id, name = name, features = features)
    }


    private fun generateProjectUniqueId() = UUID.randomUUID().toString()
}
