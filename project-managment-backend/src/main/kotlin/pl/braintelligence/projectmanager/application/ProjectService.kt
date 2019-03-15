package pl.braintelligence.projectmanager.application

import org.springframework.stereotype.Service
import pl.braintelligence.projectmanager.api.project.dto.ExistingProjectDraft
import pl.braintelligence.projectmanager.api.project.dto.NewProject
import pl.braintelligence.projectmanager.api.project.dto.NewProjectDraft
import pl.braintelligence.projectmanager.domain.project.Project
import pl.braintelligence.projectmanager.domain.project.ProjectFactory
import pl.braintelligence.projectmanager.domain.project.ProjectRepository
import pl.braintelligence.projectmanager.domain.values.Feature

@Service
class ProjectService(
        private val projectRepository: ProjectRepository,
        private val projectFactory: ProjectFactory
) {
    fun createProject(newProjectDraft: NewProjectDraft) {
        val project = projectFactory.createProjectDraft(newProjectDraft.name)
        projectRepository.save(project)
    }

    fun createProject(newProject: NewProject) {
        val features = Feature.toFeatures(newProject.features)
        val project = projectFactory.createFullProject(newProject.name, features)
        projectRepository.save(project)

    }

    fun getProjects(): List<ExistingProjectDraft> {
        val projects = projectRepository.findAll()
        return ExistingProjectDraft.mapToExistingProjectDrafts(projects)
    }
}
