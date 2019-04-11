package pl.braintelligence.projectmanager.core.team.domain.configuration

import pl.braintelligence.projectmanager.core.team.domain.Team
import pl.braintelligence.projectmanager.core.team.ports.outgoing.TeamRepository
import pl.braintelligence.projectmanager.shared.InMemoryCrudRepository

class InMemoryTeamRepository : InMemoryCrudRepository<Team, String>(), TeamRepository {

    override fun existsByName(name: String): Boolean {
        return super.contains(id = name)
    }

    override fun findByName(name: String): Team? {
        return super.findById(id = name)
    }

    override fun save(team: Team) {
        super.save(entity = team, id = team.name)
    }
}
