package pl.braintelligence.projectmanager.core.projects.domain

import org.springframework.stereotype.Component
import java.util.*

@Component
class ProjectFactory {

    fun createProjectDraft(projectName: String): Project {
        val id = UUID.randomUUID().toString()
        return Project(id, projectName)
    }



}
