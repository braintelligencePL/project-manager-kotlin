package pl.braintelligence.projectmanager.infrastructure.team.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import pl.braintelligence.projectmanager.core.team.domain.Employee
import pl.braintelligence.projectmanager.core.team.domain.Team

@Document(collection = "teams")
data class DbTeam(
        @Id private val name: String,
        private val currentlyImplementedProjects: Int,
        private val members: List<DbEmployee>
) {
    companion object {
        fun toDbTeam(team: Team): DbTeam =
                DbTeam(
                        team.name,
                        team.currentlyImplementedProjects,
                        DbEmployee.toDbEmployee(team.members)
                )

        fun toTeams(dbTeams: List<DbTeam>): List<Team> =
                dbTeams.map {
                    Team(
                            it.name,
                            it.currentlyImplementedProjects,
                            it.members.map { member -> DbEmployee.toEmployee(member) }
                    )
                }

        fun toTeam(dbTeam: DbTeam): Team? =
                Team(
                        dbTeam.name,
                        dbTeam.currentlyImplementedProjects,
                        dbTeam.members.map { DbEmployee.toEmployee(it) }
                )
    }
}
