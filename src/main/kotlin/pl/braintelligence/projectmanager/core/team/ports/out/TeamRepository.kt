package pl.braintelligence.projectmanager.core.team.ports.out

import pl.braintelligence.projectmanager.core.team.domain.Team

/**
 * Secondary Port
 */

interface TeamRepository {

    fun existsByName(name: String): Boolean

    fun findByName(name: String): Team?

    fun findAll(): List<Team>

    fun save(team: Team)

}
