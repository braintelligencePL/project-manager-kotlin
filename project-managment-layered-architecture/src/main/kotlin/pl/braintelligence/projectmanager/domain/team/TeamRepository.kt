package pl.braintelligence.projectmanager.domain.team

interface TeamRepository {
    fun existByName(id: String): Boolean
    fun save(team: Team)
    fun findAll(): List<Team>
}
