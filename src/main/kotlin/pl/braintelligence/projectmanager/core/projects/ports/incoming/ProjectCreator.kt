package pl.braintelligence.projectmanager.core.projects.ports.incoming

import pl.braintelligence.projectmanager.core.projects.domain.Project
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.NewProjectDraft

interface ProjectCreator {

    fun createProjectDraft(newProjectDraft: NewProjectDraft): Project

}
