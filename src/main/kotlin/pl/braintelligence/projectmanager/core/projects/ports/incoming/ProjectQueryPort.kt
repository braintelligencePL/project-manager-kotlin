package pl.braintelligence.projectmanager.core.projects.ports.incoming

import pl.braintelligence.projectmanager.core.projects.domain.Project

interface ProjectQueryPort {

    fun getProject(id: String): Project

}
