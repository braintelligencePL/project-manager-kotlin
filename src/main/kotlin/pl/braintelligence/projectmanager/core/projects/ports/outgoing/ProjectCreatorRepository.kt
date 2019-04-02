package pl.braintelligence.projectmanager.core.projects.ports.outgoing

import pl.braintelligence.projectmanager.core.projects.domain.Project

interface ProjectCreatorRepository {

    fun save(project: Project)

}
