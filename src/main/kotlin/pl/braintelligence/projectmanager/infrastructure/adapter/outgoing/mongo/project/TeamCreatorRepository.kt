package pl.braintelligence.projectmanager.infrastructure.adapter.outgoing.mongo.project

import kotlinx.coroutines.Dispatchers.IO
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import pl.braintelligence.projectmanager.core.projects.domain.Project
import pl.braintelligence.projectmanager.core.projects.ports.outgoing.ProjectCreatorRepository
import pl.braintelligence.projectmanager.infrastructure.adapter.outgoing.mongo.project.entities.DbProject

@Repository
interface MongoTeamCreationRepository : CrudRepository<DbProject, String>

@Component
class TeamCreatorRepository(
        private val mongo: MongoTeamCreationRepository
) : ProjectCreatorRepository {

    override fun save(project: Project) {
        val dbProject = DbProject.toDbProject(project)
        mongo.save(dbProject)
    }
}
