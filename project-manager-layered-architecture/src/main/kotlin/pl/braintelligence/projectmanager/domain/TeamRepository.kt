package pl.braintelligence.projectmanager.domain

import pl.braintelligence.projectmanager.application.team.dto.ExistingTeamDto

interface TeamRepository {
    fun exist(id: String): Boolean
    fun save(team: Team)
    fun findAll(): Team
}
