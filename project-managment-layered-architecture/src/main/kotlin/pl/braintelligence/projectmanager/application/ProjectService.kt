package pl.braintelligence.projectmanager.application

import org.springframework.stereotype.Service
import pl.braintelligence.projectmanager.application.dto.NewProjectDraftDto
import pl.braintelligence.projectmanager.domain.project.Project
import pl.braintelligence.projectmanager.domain.project.ProjectFactory
import pl.braintelligence.projectmanager.domain.project.ProjectRepository

@Service
class ProjectService(
    private val projectRepository: ProjectRepository,
    private val projectFactory: ProjectFactory
) {
    fun createProject(newProjectDraftDto: NewProjectDraftDto) {
        val project = projectFactory.createProjectDraft(newProjectDraftDto.name)
        projectRepository.save(project)
    }
}
