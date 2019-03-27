package pl.braintelligence.projectmanager.infrastructure.team

import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria.where
import org.springframework.data.mongodb.core.query.Query.query
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import pl.braintelligence.projectmanager.core.team.Team
import pl.braintelligence.projectmanager.core.team.TeamRepository
import pl.braintelligence.projectmanager.infrastructure.team.entities.DbTeam


@Repository
interface MongoTeamRepository : MongoRepository<DbTeam, String>


@Component
class MongoDbTeamRepository(
        private val mongo: MongoTeamRepository,
        private val mongoTemplate: MongoTemplate
) : TeamRepository {

    override fun existsByName(name: String): Boolean =
            mongoTemplate.exists(query(where("_id").`is`(name)), TEAMS_COLLECTION)

    override fun findByName(name: String): Team {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(): List<Team> {
        val dbTeam: List<DbTeam> = mongo.findAll().toList()
        return DbTeam.toTeams(dbTeam)
    }

    override fun save(team: Team) {
        val dbTeam = DbTeam.toDbTeam(team)
        mongo.save(dbTeam)
    }

    companion object {
        val TEAMS_COLLECTION = "teams"
    }
}
