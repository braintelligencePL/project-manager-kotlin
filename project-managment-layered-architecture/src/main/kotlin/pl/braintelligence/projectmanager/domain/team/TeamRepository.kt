package pl.braintelligence.projectmanager.domain.team

interface TeamRepository {
    fun save(team: Team)

    fun findAll(): List<Team>
    fun findByName(name: String): Team

    fun existByName(id: String): Boolean
}