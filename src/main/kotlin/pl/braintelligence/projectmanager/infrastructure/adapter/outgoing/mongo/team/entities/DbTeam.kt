import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import pl.braintelligence.projectmanager.core.team.domain.Team

@Document(collection = "teams")
data class DbTeam(
        @Id private val name: String,
        private val numberOfOngoingProjects: Int,
        private val members: List<DbEmployee>
) {
    companion object {
        fun toDbTeam(team: Team): DbTeam =
                DbTeam(
                        team.name,
                        team.numberOfOngoingProjects,
                        DbEmployee.toDbEmployee(team.members)
                )

        fun toTeams(dbTeams: List<DbTeam>): List<Team> =
                dbTeams.map {
                    Team(
                            it.name,
                            it.numberOfOngoingProjects,
                            it.members.map { member -> DbEmployee.toEmployee(member) }
                    )
                }

        fun toTeam(dbTeam: DbTeam): Team? =
                Team(
                        dbTeam.name,
                        dbTeam.numberOfOngoingProjects,
                        dbTeam.members.map { DbEmployee.toEmployee(it) }
                )
    }
}
