package pl.braintelligence.projectmanager.infrastructure.adapter.outgoing.mongo.project.entities

import org.springframework.data.mongodb.core.mapping.Document
import pl.braintelligence.projectmanager.core.projects.domain.Project
import pl.braintelligence.projectmanager.core.projects.domain.Status

@Document(collection = "projects")
class DbProject(
        val id: String,
        val name: String,
        val status: Status = Status.TO_DO,
        val teamAssigned: String = ""
) {
    companion object {
        fun toDbProject(project: Project): DbProject = DbProject(
                project.id,
                project.name,
                project.status,
                project.teamAssigned
        )
    }
}
