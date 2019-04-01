package pl.braintelligence.projectmanager.core.projects.domain

import org.springframework.stereotype.Service
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectCreator
import pl.braintelligence.projectmanager.core.projects.ports.outgoing.ProjectRepository
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.NewProjectDraft

@Service
class ProjectFacade(
        private val projectFactory: ProjectFactory,
        private val projectRepository: ProjectRepository
) : ProjectCreator {

    override fun createProjectDraft(newProjectDraft: NewProjectDraft): Project =
            projectFactory.createProjectDraft(newProjectDraft.name)
                    .also { projectRepository.save(it) }


}
