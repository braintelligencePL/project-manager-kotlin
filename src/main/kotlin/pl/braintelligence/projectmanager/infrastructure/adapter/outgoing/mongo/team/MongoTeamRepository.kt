package pl.braintelligence.projectmanager.infrastructure.adapter.outgoing.mongo.team

import DbTeam
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import pl.braintelligence.projectmanager.core.team.domain.Team
import pl.braintelligence.projectmanager.core.team.ports.outgoing.TeamRepository


@Repository
interface CrudTeamRepository : CrudRepository<DbTeam, String> {
    fun findByName(name: String): DbTeam?
}

/**
 *  Secondary adapter
 */

@Component
class MongoTeamRepository(
        private val mongo: CrudTeamRepository
) : TeamRepository {

    override fun existsByName(name: String): Boolean =
            mongo.existsById(name)

    override fun findByName(name: String): Team? {
        val dbTeam = mongo.findByName(name)
        return dbTeam?.let { DbTeam.toTeam(it) }
    }

    override fun findAll(): List<Team> = DbTeam.toTeams(
            mongo.findAll().toList())

    override fun save(team: Team) {
        DbTeam.toDbTeam(team).also { mongo.save(it) }
    }
}
