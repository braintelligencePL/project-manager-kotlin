package pl.braintelligence.projectmanager.core.projects.domain

import org.springframework.stereotype.Service
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectQueryPort
import pl.braintelligence.projectmanager.core.projects.ports.outgoing.ProjectQueryRepository

@Service
class ProjectQueryService(
        private val projectQueryRepository: ProjectQueryRepository
) : ProjectQueryPort {

    override fun getProject(id: String): Project =
            projectQueryRepository.findById(id)
                    ?: throw MissingProjectException("Project does not exist.")

    override fun getProjects(): List<Project> =
            projectQueryRepository.findAll()



}
