package pl.braintelligence.projectmanager.core.projects.ports.incoming

import pl.braintelligence.projectmanager.core.projects.domain.Project
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.ProjectDraft
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.ProjectWithFeatures

interface ProjectCreator {

    fun createProjectDraft(projectDraft: ProjectDraft): Project

    fun createProjectWithFeatures(projectWithFeatures: ProjectWithFeatures): Project

    fun getProject(id: String): Project

}
