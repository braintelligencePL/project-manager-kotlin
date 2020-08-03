package pl.braintelligence.projectmanager.infrastructure.adapter.outgoing.mongo.project

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import pl.braintelligence.projectmanager.core.projects.domain.Project
import pl.braintelligence.projectmanager.core.projects.ports.outgoing.ProjectQueryRepository
import pl.braintelligence.projectmanager.infrastructure.adapter.outgoing.mongo.project.entities.DbProject

@Repository
interface MongoTeamQueryRepository : MongoRepository<DbProject, String>

@Component
class TeamQueryRepository(
        private val mongo: MongoTeamCreationRepository
) : ProjectQueryRepository {

    override fun findAll(): List<Project> = DbProject.toProjects(mongo.findAll())

    override fun findById(id: String): Project? = DbProject.toProject(mongo.findById(id).get())

}
