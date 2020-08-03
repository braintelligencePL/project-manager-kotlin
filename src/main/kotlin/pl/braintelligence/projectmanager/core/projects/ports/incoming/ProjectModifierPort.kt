package pl.braintelligence.projectmanager.core.projects.ports.incoming

import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.project.dto.ProjectEndCondition
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.project.dto.UpdateProject

interface ProjectModifierPort {

    fun updateProject(projectId: String, updateProject: UpdateProject)

    fun startProject(projectId: String)

    fun endProject(projectId: String, projectEndCondition: ProjectEndCondition)

}
