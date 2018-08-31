package pl.braintelligence.projectmanager.infrastructure.team.entities

import org.springframework.data.annotation.Id
import pl.braintelligence.projectmanager.domain.team.Team
import pl.braintelligence.projectmanager.domain.values.Employee
import pl.braintelligence.projectmanager.domain.values.JobPosition

data class DbTeam(
    @Id val name: String,
    val currentlyImplementedProjects: Int,
    val members: List<DbEmployee>
) {
    companion object {
        fun fromTeam(team: Team): DbTeam =
            DbTeam(
                team.name,
                team.currentlyImplementedProjects,
                team.members.map {
                    DbEmployee.toDbEmployee(it)
                }
            )

        fun toTeams(dbTeams: List<DbTeam>): List<Team> =
            dbTeams.map {
                Team(
                    it.name,
                    it.currentlyImplementedProjects,
                    it.members.map { DbEmployee.fromDbEmployee(it) }
                )
            }

        fun toTeam(dbTeam: DbTeam): Team =
            Team(
                dbTeam.name,
                dbTeam.currentlyImplementedProjects,
                dbTeam.members.map { DbEmployee.fromDbEmployee(it) }
            )
    }
}

