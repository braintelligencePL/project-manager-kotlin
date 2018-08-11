package pl.braintelligence.projectmanager.persistance

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import pl.braintelligence.projectmanager.domain.Team
import pl.braintelligence.projectmanager.domain.TeamRepository

@Repository
interface DbTeamRepository : MongoRepository<DbTeam, String>


@Component
class TeamRepositoryImpl(
        val dbTeamRepository: DbTeamRepository
) : TeamRepository {
    override fun findAll(): List<Team> {
        val dbTeams: List<DbTeam> = dbTeamRepository.findAll()
        return DbTeam.toTeams(dbTeams)
    }

    override fun save(team: Team) {
        val dbTeam = DbTeam.fromTeam(team)
        dbTeamRepository.save(dbTeam)
    }

    override fun exist(id: String): Boolean {
        return dbTeamRepository.existsById(id)
    }
}
