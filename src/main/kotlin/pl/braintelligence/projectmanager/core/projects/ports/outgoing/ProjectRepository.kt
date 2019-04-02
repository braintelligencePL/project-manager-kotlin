package pl.braintelligence.projectmanager.core.projects.ports.outgoing

import pl.braintelligence.projectmanager.core.projects.domain.Project

interface ProjectRepository {

    fun save(project: Project)

    fun findById(id: String): Project?

}
