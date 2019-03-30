package pl.braintelligence.projectmanager.core.team.domain.configuration

import pl.braintelligence.projectmanager.core.team.ports.out.TeamRepository
import pl.braintelligence.projectmanager.core.team.domain.Team
import java.util.concurrent.ConcurrentHashMap

class InMemoryTeamRepository : TeamRepository {

    private var map = ConcurrentHashMap<String, Team>()

    override fun existsByName(name: String): Boolean {
        return map.containsKey(name)
    }

    override fun findByName(name: String): Team? {
        return map[name]
    }

    override fun findAll(): List<Team> {
        return map.values.toList()
    }

    override fun save(team: Team) {
        map[team.name] = team
    }

}
