package pl.braintelligence.projectmanager.infrastructure.persistance

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import pl.braintelligence.projectmanager.domain.Team
import pl.braintelligence.projectmanager.domain.TeamRepository

@Component
class TeamRepositoryImpl(
        val dbTeamRepository: DbTeamRepository
) : TeamRepository {

    override fun save(team: Team) {
        val dbTeam = DbTeam.fromTeam(team)
        dbTeamRepository.save(dbTeam)
    }

    override fun exist(id: String): Boolean {
        return dbTeamRepository.existsById(id)
    }
}

@Repository
interface DbTeamRepository: MongoRepository<DbTeam, String> {

}