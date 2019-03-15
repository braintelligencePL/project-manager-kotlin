package pl.braintelligence.projectmanager.infrastructure.persistence.team

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import pl.braintelligence.projectmanager.domain.team.Team

@Document(collection = "teams")
data class DbTeam(
        @Id val name: String,
        val currentlyImplementedProjects: Int,
        val members: List<DbEmployee>
) {
    companion object {
        fun fromTeam(team: Team): DbTeam =
                DbTeam(
                        team.name,
                        team.currentProjects,
                        team.members.map {
                            DbEmployee.toDbEmployee(it)
                        }
                )

        fun toTeams(dbTeams: List<DbTeam>): List<Team> =
                dbTeams.map {
                    Team(
                            it.name,
                            it.currentlyImplementedProjects,
                            ArrayList(it.members.map {
                                DbEmployee.fromDbEmployee(
                                        it
                                )
                            })
                    )
                }

        fun toTeam(dbTeam: DbTeam): Team =
                dbTeam.run {
                    Team(
                            dbTeam.name,
                            dbTeam.currentlyImplementedProjects,
                            ArrayList(dbTeam.members.map {
                                DbEmployee.fromDbEmployee(
                                        it
                                )
                            })
                    )
                }
    }
}
