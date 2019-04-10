package pl.braintelligence.projectmanager.infrastructure.adapter.outgoing.mongo.project.entities

import arrow.core.Try
import arrow.core.getOrElse
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import pl.braintelligence.projectmanager.core.projects.domain.Feature
import pl.braintelligence.projectmanager.core.projects.domain.PriorityLevel
import pl.braintelligence.projectmanager.core.projects.domain.Project
import pl.braintelligence.projectmanager.core.projects.domain.Status

@Document(collection = "projects")
class DbProject(
        @Id val id: String,
        val name: String,
        val status: Status = Status.TO_DO,
        val teamAssigned: String = "",
        val features: List<DbFeature> = listOf()
) {
    companion object {
        fun toDbProject(project: Project): DbProject = DbProject(
                project.id,
                project.name,
                project.status,
                project.teamAssigned,
                project.features.map {
                    DbFeature(
                            name = it.name,
                            status = it.status.toString(),
                            priorityLevel = it.priorityLevel.toString()
                    )
                }
        )

        fun toProject(dbProject: DbProject): Project = Project(
                dbProject.id,
                dbProject.name,
                dbProject.status,
                dbProject.teamAssigned,
                dbProject.features.map {
                    Feature(
                            name = it.name,
                            status = Try { Status.valueOf(it.status) }
                                    .getOrElse { throw IllegalArgumentException("Not valid Feature status") },
                            priorityLevel = Try { PriorityLevel.valueOf(it.priorityLevel) }
                                    .getOrElse { throw IllegalArgumentException("Not valid Feature priorityLevel") }
                    )
                }

        )

    }
}
