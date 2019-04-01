package pl.braintelligence.projectmanager.core.team.domain.configuration

import pl.braintelligence.projectmanager.core.team.domain.Team
import pl.braintelligence.projectmanager.core.team.ports.outgoing.TeamRepository
import java.util.concurrent.ConcurrentHashMap
import kotlin.reflect.KClass

class InMemoryTeamRepository : InMemoryCrudRepository<Team, String>(), TeamRepository {

    override fun existsByName(name: String): Boolean {
        return super.contains(name)
    }

    override fun findByName(name: String): Team? {
        return super.findById(name)
    }

    override fun save(team: Team) {
        super.save(team, team.name)
    }
}
