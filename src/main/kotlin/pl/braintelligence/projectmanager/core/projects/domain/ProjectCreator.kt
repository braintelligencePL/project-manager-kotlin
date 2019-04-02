package pl.braintelligence.projectmanager.core.projects.domain

import org.springframework.stereotype.Service
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectCreatorPort
import pl.braintelligence.projectmanager.core.projects.ports.outgoing.ProjectRepository
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.ProjectDraft
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.ProjectWithFeatures

@Service
class ProjectCreator(
        private val projectFactory: ProjectFactory,
        private val projectRepository: ProjectRepository
) : ProjectCreatorPort {

    override fun createProjectDraft(projectDraft: ProjectDraft): Project =
            projectFactory.createProjectDraft(projectDraft.projectName)
                    .also { projectRepository.save(it) }

    override fun createProjectWithFeatures(projectWithFeatures: ProjectWithFeatures): Project =
            projectFactory.createProjectWithFeatures(projectWithFeatures)
                    .also { projectRepository.save(it) }

}
