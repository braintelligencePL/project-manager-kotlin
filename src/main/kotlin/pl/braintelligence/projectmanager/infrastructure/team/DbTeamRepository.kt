package pl.braintelligence.projectmanager.infrastructure.team

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import pl.braintelligence.projectmanager.core.team.ports.out.TeamRepository
import pl.braintelligence.projectmanager.core.team.domain.Team
import pl.braintelligence.projectmanager.infrastructure.team.entities.DbTeam


@Repository
interface MongoTeamRepository : MongoRepository<DbTeam, String> {
    fun findByName(name: String): DbTeam?
}

/**
 * Secondary adapter
 */

@Component
class MongoDbTeamRepository(
        private val mongo: MongoTeamRepository
) : TeamRepository {

    override fun existsByName(name: String): Boolean =
            mongo.existsById(name)

    override fun findByName(name: String): Team? {
        val dbTeam = mongo.findByName(name)
        return dbTeam?.let { DbTeam.toTeam(it) }
    }

    override fun findAll(): List<Team> {
        val dbTeam: List<DbTeam> = mongo.findAll().toList()
        return DbTeam.toTeams(dbTeam)
    }

    override fun save(team: Team) {
        val dbTeam = DbTeam.toDbTeam(team)
        mongo.save(dbTeam)
    }
}
