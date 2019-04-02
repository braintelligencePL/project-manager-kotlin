package pl.braintelligence.projectmanager.core.projects.domain.configuration

import pl.braintelligence.projectmanager.core.projects.domain.Project
import pl.braintelligence.projectmanager.core.projects.ports.outgoing.ProjectRepository
import pl.braintelligence.projectmanager.shared.InMemoryCrudRepository

class InMemoryProjectRepository : InMemoryCrudRepository<Project, String>(), ProjectRepository {

    override fun save(project: Project) {
        super.save(entity = project, id = project.id)
    }
}
