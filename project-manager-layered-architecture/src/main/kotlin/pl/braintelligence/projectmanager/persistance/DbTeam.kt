package pl.braintelligence.projectmanager.persistance

import org.springframework.data.annotation.Id
import pl.braintelligence.projectmanager.domain.Team

data class DbTeam(
        @Id val name: String
) {
    companion object {
        fun fromTeam(team: Team): DbTeam = DbTeam(team.name)
    }
}