package pl.braintelligence.projectmanager.infrastructure.team

import org.slf4j.LoggerFactory
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import pl.braintelligence.projectmanager.domain.team.Team
import pl.braintelligence.projectmanager.domain.team.TeamRepository
import java.lang.invoke.MethodHandles

@Component
class TeamRepositoryImpl(
    private val dbTeamRepository: DbTeamRepository
) : TeamRepository {

    override fun findAll(): List<Team> {
        val dbTeams: List<DbTeam> = dbTeamRepository.findAll()
        return DbTeam.toTeams(dbTeams)
    }

    override fun save(team: Team) {
        val dbTeam = DbTeam.fromTeam(team)
        dbTeamRepository.save(dbTeam)
        logger.info("Team saved {}", dbTeam)
    }

    override fun findByName(name: String): Team? {
        val dbTeam = dbTeamRepository.findByName(name)
        return dbTeam?.let { DbTeam.toTeam(it) }
    }

    override fun existByName(id: String): Boolean = dbTeamRepository.existsById(id)

    companion object {
        private val logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass())
    }
}

@Repository
interface DbTeamRepository : MongoRepository<DbTeam, String> {
    fun findByName(name: String): DbTeam?
}