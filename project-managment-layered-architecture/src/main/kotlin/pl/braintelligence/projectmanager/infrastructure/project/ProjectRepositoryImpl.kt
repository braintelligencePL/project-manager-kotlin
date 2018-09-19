package pl.braintelligence.projectmanager.infrastructure.project

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import pl.braintelligence.projectmanager.domain.project.Project
import pl.braintelligence.projectmanager.domain.project.ProjectRepository
import pl.braintelligence.projectmanager.infrastructure.team.entities.DbTeam

class ProjectRepositoryImpl(
    private val dbProjectRepository: DbProjectRepository
) : ProjectRepository {
    override fun save(project: Project) {
        TODO("save project draft")
    }
}

@Repository
interface DbProjectRepository : MongoRepository<DbTeam, String> {
}