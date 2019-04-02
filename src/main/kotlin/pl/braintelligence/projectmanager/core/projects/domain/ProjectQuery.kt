package pl.braintelligence.projectmanager.core.projects.domain

import org.springframework.stereotype.Service
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectQueryPort
import pl.braintelligence.projectmanager.core.projects.ports.outgoing.ProjectCreatorRepository

@Service
class ProjectQuery(
        private val projectCreatorRepository: ProjectCreatorRepository
) : ProjectQueryPort {

    override fun getProject(id: String): Project =
            projectCreatorRepository.findById(id)
                    ?: throw MissingProjectException("Project does not exist.")

}
