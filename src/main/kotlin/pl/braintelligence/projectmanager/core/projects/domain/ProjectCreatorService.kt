package pl.braintelligence.projectmanager.core.projects.domain

import org.springframework.stereotype.Service
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectCreatorPort
import pl.braintelligence.projectmanager.core.projects.ports.outgoing.ProjectCreatorRepository
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.ProjectDraft
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.ProjectWithFeatures

@Service
class ProjectCreatorService(
        private val projectFactory: ProjectFactory,
        private val projectCreatorRepository: ProjectCreatorRepository
) : ProjectCreatorPort {

    override fun createProjectDraft(projectDraft: ProjectDraft): Project =
            projectFactory.createProjectDraft(projectDraft.projectName)
                    .also { projectCreatorRepository.save(it) }

    override fun createProjectWithFeatures(projectWithFeatures: ProjectWithFeatures): Project {
        val features = Feature.toFeatures(projectWithFeatures.features)

        return projectFactory.createProjectWithFeatures(projectWithFeatures.projectName, features)
                .also { projectCreatorRepository.save(it) }
    }

}
