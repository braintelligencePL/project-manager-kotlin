package pl.braintelligence.projectmanager.application

import org.springframework.stereotype.Service
import pl.braintelligence.projectmanager.application.dto.NewProjectDraft
import pl.braintelligence.projectmanager.domain.project.ProjectFactory
import pl.braintelligence.projectmanager.domain.project.ProjectRepository

@Service
class ProjectService(
    private val projectRepository: ProjectRepository,
    private val projectFactory: ProjectFactory
) {
    fun createProject(newProjectDraft: NewProjectDraft) {
        val project = projectFactory.createProjectDraft(newProjectDraft.name)
        projectRepository.save(project)
    }
}
