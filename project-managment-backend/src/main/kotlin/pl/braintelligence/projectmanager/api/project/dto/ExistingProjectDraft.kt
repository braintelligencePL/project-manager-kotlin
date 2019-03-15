package pl.braintelligence.projectmanager.api.project.dto

import pl.braintelligence.projectmanager.domain.project.Project

data class ExistingProjectDraft(
        val id: String,
        val name: String
) {
    companion object {
        fun mapToExistingProjectDrafts(projects: List<Project>) = projects.map { mapToExistingProjectDraft(it) }

        private fun mapToExistingProjectDraft(project: Project) = ExistingProjectDraft(
                project.id,
                project.name
        )
    }
}

