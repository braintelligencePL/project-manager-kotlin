package pl.braintelligence.projectmanager.domain

interface TeamRepository {
    fun exist(id: String): Boolean
    fun save(team: Team)
    fun findAll(): List<Team>
}
