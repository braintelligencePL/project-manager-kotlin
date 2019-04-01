package pl.braintelligence.projectmanager.infrastructure.adapter.outgoing.mongo.project

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import pl.braintelligence.projectmanager.core.projects.domain.Project
import pl.braintelligence.projectmanager.core.projects.ports.outgoing.ProjectRepository
import pl.braintelligence.projectmanager.infrastructure.adapter.outgoing.mongo.project.entities.DbProject

@Repository
interface CrudProjectRepository : CrudRepository<DbProject, String> {

}

@Component
class MongoProjectRepository(
        private val mongo: CrudProjectRepository
) : ProjectRepository {
    override fun save(project: Project) {
        val dbProject = DbProject.toDbProject(project)
        mongo.save(dbProject)
    }
}
