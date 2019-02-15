package pl.braintelligence.projectmanager.infrastructure.persistence.project

import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository
import pl.braintelligence.projectmanager.domain.project.Project
import pl.braintelligence.projectmanager.domain.project.ProjectRepository

@Repository
class ProjectRepositoryImpl(
    val mongoTemplate: MongoTemplate
) : ProjectRepository {

    override fun save(project: Project) {
        mongoTemplate.save(project, PROJECTS_COLLECTION)
    }

    companion object {
        private const val PROJECTS_COLLECTION = "projects"
    }
}