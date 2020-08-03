package pl.braintelligence.projectmanager.core.projects.domain.configuration

import pl.braintelligence.projectmanager.core.projects.domain.Project
import pl.braintelligence.projectmanager.core.projects.ports.outgoing.ProjectCreatorRepository
import pl.braintelligence.projectmanager.core.projects.ports.outgoing.ProjectQueryRepository
import pl.braintelligence.projectmanager.shared.InMemoryCrudRepository

open class InMemoryProjectRepository
    : InMemoryCrudRepository<Project, String>(),
        ProjectCreatorRepository, ProjectQueryRepository {

    override fun save(project: Project) {
        super.save(entity = project, id = project.id)
    }
}
