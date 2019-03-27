package pl.braintelligence.projectmanager.core.team

interface TeamRepository {

    fun existsByName(name: String): Boolean

    fun findByName(name: String): Team

    fun findAll(): List<Team>

    fun save(team: Team)

}
