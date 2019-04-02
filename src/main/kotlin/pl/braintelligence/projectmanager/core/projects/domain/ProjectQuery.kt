package pl.braintelligence.projectmanager.core.projects.domain

import org.springframework.stereotype.Service
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectQueryPort
import pl.braintelligence.projectmanager.core.projects.ports.outgoing.ProjectRepository

@Service
class ProjectQuery(
        private val projectRepository: ProjectRepository
) : ProjectQueryPort {

    override fun getProject(id: String): Project =
            projectRepository.findById(id)
                    ?: throw MissingProjectException("Project does not exist.")

}
