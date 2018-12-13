package pl.braintelligence.projectmanager.domain.project

interface ProjectRepository {

    fun save(project: Project)
}
