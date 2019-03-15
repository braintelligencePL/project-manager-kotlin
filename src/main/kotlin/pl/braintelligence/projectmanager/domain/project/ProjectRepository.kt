package pl.braintelligence.projectmanager.domain.project

interface ProjectRepository {

    fun save(project: Project)

    fun findAll(): List<Project>
}
