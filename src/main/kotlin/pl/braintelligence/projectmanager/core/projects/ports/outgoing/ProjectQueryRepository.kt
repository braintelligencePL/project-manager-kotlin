package pl.braintelligence.projectmanager.core.projects.ports.outgoing

import pl.braintelligence.projectmanager.core.projects.domain.Project

interface ProjectQueryRepository {

    fun findById(id: String): Project?

}
